package common

import com.android.ddmlib.IDevice
import generateInitialList
import javafx.beans.property.SimpleStringProperty
import json.convertToDistanceListAndNormalize
import json.parsePhoneOutput
import kotlinx.coroutines.*
import map.MapController
import mapGenerated
import tornadofx.Controller
import updateValues
import utils.getLogsByTag
import utils.showAlarmDialog
import utils.showAlertDialog

class RootController : Controller() {
    private val rootView: RootView by inject()
    val distances = ArrayList<DistanceInfo>()
    val alarmDevices = ArrayList<DistanceInfo>()
    private val mapController: MapController by inject()
    private var device: IDevice? = null
    private val jsonTag = "JSON_RTT"

    val alarmStrings = SimpleStringProperty()
    var uploadJob: Job? = null
    fun uploadData() {
        uploadJob?.cancel()
        uploadJob = CoroutineScope(Dispatchers.IO).launch {
//            generateInitialList()
            while (isActive) {
                if (device == null) {
                    device =
                        getFirstDevice() ?: return@launch showAlertDialog("Device not found. Data cannot be loaded")
                }
                val logsByTag = device!!.getLogsByTag(jsonTag)
                val distances = parsePhoneOutput(logsByTag)

                if (distances.isEmpty()) {
                    cancel()
                    return@launch showAlertDialog("Json not found in logcat output")
                }

                val normalizedDistances = convertToDistanceListAndNormalize(distances)

//                val normalizedDistances = ArrayList<DistanceInfo>()
//                mapGenerated.forEach { (_, value) -> normalizedDistances.add(value) }
//                setNewDistances(Pair(normalizedDistances, ArrayList()))
                setNewDistances(normalizedDistances)
                calculateMap()
                rootView.updateAll()
                delay(10_000)
//                updateValues()
            }
        }
    }

    fun stopUpdateJob() = uploadJob?.cancel()

    private fun calculateMap() {
        val mapDictionary = LinkedHashMap<String, DistanceInfo>()
        distances.forEach { mapDictionary[it.phoneName] = it }
        mapController.calculateDistances(mapDictionary)
    }

    private fun setNewDistances(distances: Pair<List<DistanceInfo>, List<DistanceInfo>>) {
        this.distances.clear()
        this.distances.addAll(distances.first)
        this.alarmDevices.clear()
        this.alarmDevices.addAll(distances.second)
        if (distances.second.isNotEmpty()) {
            showAlarmDialog(getAlarmDeviceNames().toString(), "Found devices with alarm")
        }
        val alarmDeviceNames = getAlarmDeviceNames()
        if (alarmDeviceNames.isEmpty()) {
            alarmStrings.set("Devices with alarm 0")
        } else {
            alarmStrings.set("Devices with alarm ${getAlarmDeviceNames()}")
        }
    }


    private fun getAlarmDeviceNames() = alarmDevices.map { it.phoneName }

}
