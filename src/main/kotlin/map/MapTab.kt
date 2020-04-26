package map

import javafx.scene.Node
import javafx.scene.chart.LineChart
import javafx.scene.chart.NumberAxis
import javafx.scene.control.Tooltip
import kotlinx.coroutines.*
import tornadofx.*

class MapTab : View("Map") {
    private var chart: LineChart<Number, Number> by singleAssign()
    private val mapController: MapController by inject()
    override val root = vbox {
        val firstAxis = NumberAxis(-1.0, 32.0, 1.0)
        val secondAxis = NumberAxis(-1.0, 32.0, 1.0)
        chart = linechart("Devices Map", firstAxis, secondAxis)
    }

    fun paintMap() {
        clearChart()
        addDevicesToMap()
        addTooltipsToChartAndAddAnimation()
    }

    private fun clearChart() {
        chart.data.clear()
    }

    private fun addDevicesToMap() {
        mapController.devicesCoordinates.forEach { position ->
            chart.series(position.device.phoneName) {
                var extra =
                    position.device.phoneName + "\nPulse: " + position.device.pulse + "\nPulseOx: " + position.device.pulseOx
                if (position.device.isAlarm) {
                    extra += "\nALARM"
                }
                data(position.xCoordinate / 1000, position.yCoordinate / 1000, extra)
            }
        }
    }

    private val jobList = ArrayList<Job>()

    private fun addTooltipsToChartAndAddAnimation() {
        jobList.forEach { it.cancel() }
        for (series in chart.data) {
            for (data in series.data) {
                Tooltip.install(data.node, Tooltip(data.extraValue.toString()))
                if (data.extraValue.toString().contains("ALARM")) {
                    addAnimationToNode(data.node)
                    data.node.style = "-fx-background-color:red"
                }
            }
        }
    }

    private fun addAnimationToNode(node: Node) {
        jobList.add(CoroutineScope(Dispatchers.IO).launch {
            var wasMinimized = false
            while (isActive) {
                if (wasMinimized) {
                    node.scaleX = 2.0
                    node.scaleY = 2.0
                } else {
                    node.scaleX = 0.5
                    node.scaleY = 0.5
                }
                wasMinimized = !wasMinimized
                delay(500)
            }
        })
    }

}
