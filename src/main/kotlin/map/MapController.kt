package map

import common.DistanceInfo
import tornadofx.Controller

class MapController : Controller() {

    var devicesCoordinates: ArrayList<DevicePosition> = ArrayList()

    fun calculateDistances(distances: Map<String, DistanceInfo>) {
        val helper = MapCalculationHelper(distances)
        devicesCoordinates = helper.calculate()
    }
}
