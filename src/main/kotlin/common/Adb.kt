package common

import com.android.ddmlib.AndroidDebugBridge
import com.android.ddmlib.IDevice
import kotlinx.coroutines.delay
import tornadofx.singleAssign

private var bridge: AndroidDebugBridge by singleAssign()

fun adbInit() {
    AndroidDebugBridge.init(false)
    bridge = AndroidDebugBridge.createBridge("adb", false)
}

suspend fun getFirstDevice(): IDevice? {
    println("Finding devices")
    var tryCount = 0
    while (tryCount < 5) {
        val devices = bridge.devices
        if (devices.isNotEmpty()) {
            println("Device found ${devices[0]}")
            return devices[0]
        }
        delay(2000)
        tryCount++
    }
    println("Device not found")
    return null
}

fun adbShutdown() {
    AndroidDebugBridge.terminate()
}