import common.DistanceInfo
import java.util.concurrent.ThreadLocalRandom

private const val namePrefix = "Patient"
val mapGenerated = LinkedHashMap<String, DistanceInfo>()

fun generateInitialList() {
    for (i in 1..50) {
        val pulse = ThreadLocalRandom.current().nextInt(70,120)
        val pulseOx = ThreadLocalRandom.current().nextInt(90,100)
        val info = if (i != 45)
            DistanceInfo("${namePrefix}_$i", LinkedHashMap(), false,pulse,pulseOx)
        else
            DistanceInfo("${namePrefix}_$i", LinkedHashMap(),true,pulse,pulseOx)
        mapGenerated[info.phoneName] = info
    }
    for (first in mapGenerated) {
        for (second in mapGenerated) {
            if (first.key != second.key) {
                if (second.value.getDistanceToPhoneByNameOrDefault(first.key) == -1) {
                    val distance = ThreadLocalRandom.current().nextInt(1000, 20_000)
                    first.value.distanceMap[second.key] = distance
                } else {
                    first.value.distanceMap[second.key] = second.value.getDistanceToPhoneByNameOrDefault(first.key)
                }
            }
        }
    }
}

fun updateValues() {

    mapGenerated.forEach { (_, map) ->
        map.distanceMap.forEach { (key, value) ->
            val maxChange = (value * .05).toInt()
            val change = ThreadLocalRandom.current().nextInt(0, maxChange + 1)
            val action = ThreadLocalRandom.current().nextInt(0, 100)
            if (action > 50) {
                map.distanceMap[key] = value + change
            } else {
                map.distanceMap[key] = value - change
            }
        }
    }
}

fun main() {
    generateInitialList()
    updateValues()
}