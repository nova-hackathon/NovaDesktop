package json

data class JsonDistances(
    val distanceList: List<Distance>,
    val isAlarm: Boolean,
    val phoneId: String,
    val phoneName: String,
    val pulse: Int,
    val pulseOx: Int
) {

    fun findDistanceByPhoneName(phoneName: String): Distance {
        return distanceList.firstOrNull { it.phoneName == phoneName } ?: Distance(-1, phoneName)
    }

    fun hasDifferentName(anotherDistance: JsonDistances): Boolean = phoneName != anotherDistance.phoneName
}