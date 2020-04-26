package map

import common.DistanceInfo

data class DevicePosition(val device: DistanceInfo, val xCoordinate: Int, val yCoordinate: Int) {
    constructor(device: DistanceInfo, coordinates: Pair<Int, Int>) : this(
        device,
        coordinates.first,
        coordinates.second
    )
}