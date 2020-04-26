package json

import com.google.gson.Gson
import common.DistanceInfo
import utils.getOrAddDefault

private const val startJsonTag = "StartJson"

fun parsePhoneOutput(phoneOutPut: String): List<JsonDistances> {
    val getLastJson = getLastJsonFromLogcat(phoneOutPut)
    if (getLastJson.isEmpty()) {
        return emptyList()
    }
    val normalizedOutput = getNormalizedOutput(getLastJson)
    return convertJsonToObject(normalizedOutput)
}

fun convertJsonToObject(normalizedOutput: List<String>): List<JsonDistances> {
    val list = ArrayList<JsonDistances>()
    normalizedOutput.forEach {
        runCatching {
            val distance = parseJson(it)
            list.add(distance)
        }
    }
    return list
}

private data class TmpInfo(
    val isAlarm: Boolean,
    val pulse: Int,
    val pulseOx: Int,
    val map: LinkedHashMap<String, Int> = LinkedHashMap<String, Int>()
)

fun convertToDistanceListAndNormalize(distances: List<JsonDistances>): Pair<List<DistanceInfo>, List<DistanceInfo>> {
    val tmpMap = LinkedHashMap<String, TmpInfo>()
    for (firstDistance in distances) {
        for (secondDistance in distances) {
            if (secondDistance.hasDifferentName(firstDistance)) {
                val secondDistanceFromFirst = firstDistance.findDistanceByPhoneName(secondDistance.phoneName)
                val firstDistanceFromSecond = secondDistance.findDistanceByPhoneName(firstDistance.phoneName)
                val mean: Int = calculateMean(secondDistanceFromFirst, firstDistanceFromSecond)
                val secondMap =
                    tmpMap.getOrAddDefault(
                        firstDistanceFromSecond.phoneName,
                        TmpInfo(firstDistance.isAlarm, firstDistance.pulse, firstDistance.pulseOx)
                    )
                val firstMap =
                    tmpMap.getOrAddDefault(
                        secondDistanceFromFirst.phoneName,
                        TmpInfo(secondDistance.isAlarm, secondDistance.pulse, secondDistance.pulseOx)
                    )
                secondMap.map[secondDistanceFromFirst.phoneName] = mean
                firstMap.map[firstDistanceFromSecond.phoneName] = mean
            }
        }
    }
    return convertDistanceListToMap(tmpMap)
}

private fun convertDistanceListToMap(map: LinkedHashMap<String, TmpInfo>): Pair<List<DistanceInfo>, List<DistanceInfo>> {
    val list = ArrayList<DistanceInfo>()
    val alarmDevices = ArrayList<DistanceInfo>()
    map.forEach { (name, pair) ->
        val distanceInfo = DistanceInfo(name, pair.map, pair.isAlarm, pair.pulse, pair.pulseOx)
        list.add(distanceInfo)
        if (pair.isAlarm) alarmDevices.add(distanceInfo)
    }
    return Pair(list, alarmDevices)
}

private fun calculateMean(first: Distance, second: Distance): Int =
    if (isHasCorrectDistance(first, second)) {
        (first.distance + second.distance) / 2
    } else {
        if (first.distance > second.distance) first.distance else second.distance
    }

private fun isHasCorrectDistance(first: Distance, second: Distance): Boolean =
    first.distance > 1 && second.distance > 1

fun getLastJsonFromLogcat(phoneOutPut: String): List<String> {
    val outputLines = phoneOutPut.split("\n")
    val lastJsonStartIndex = getLastJsonStartIndex(outputLines)
    return if (lastJsonStartIndex != -1)
        outputLines.subList(lastJsonStartIndex, outputLines.size)
    else
        emptyList()
}

fun getNormalizedOutput(lines: List<String>): List<String> =
    lines.map { removeLogsMeta(it) }.filter { isCorrectJson(it) }

fun isCorrectJson(line: String) = line.startsWith("{") && line.endsWith("}")

fun removeLogsMeta(logLine: String) =
    logLine.split("JSON_RTT: ").getOrElse(1) { logLine }

fun getLastJsonStartIndex(outputLines: List<String>): Int {
    var lastIndex = -1
    for (index in outputLines.indices) {
        if (outputLines[index].contains(startJsonTag))
            lastIndex = index
    }
    return lastIndex
}

fun parseJson(json: String): JsonDistances = Gson().fromJson(json, JsonDistances::class.java)