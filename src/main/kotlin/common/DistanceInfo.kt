package common

data class DistanceInfo(val phoneName: String, val distanceMap: LinkedHashMap<String, Int>, val isAlarm : Boolean, val pulse :Int, val pulseOx :Int) {
    fun getDistanceToPhoneByNameOrDefault(phoneName: String, default: Int = -1) =
        distanceMap.getOrDefault(phoneName, default)
}
