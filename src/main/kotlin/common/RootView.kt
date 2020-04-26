package common

import javafx.application.Platform
import javafx.geometry.Pos
import javafx.scene.control.TabPane
import javafx.scene.text.Text
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import map.MapTab
import matrix.MatrixTab
import tornadofx.*
import utils.getWindowMinSize


class RootView : View("Nova") {
    private val matrixTab: MatrixTab by inject()
    private val mapTab: MapTab by inject()
    private val controller: RootController by inject()

    private var alarmText: Text by singleAssign()

    override val root = vbox {
        val (minHeight, minWidth) = getWindowMinSize()
        setMinSize(minWidth, minHeight)
        menubar {
            menu("Action") {
                item("Upload Data").setOnAction { controller.uploadData() }
                item("Stop uploading").setOnAction { controller.stopUpdateJob() }
                item("Quit").setOnAction { Platform.exit() }
            }
        }
        tabpane {
            tabClosingPolicy = TabPane.TabClosingPolicy.UNAVAILABLE
            tab<MatrixTab>()
            tab<MapTab>()
        }
        hbox {
            alarmText = text {
                style = "-fx-text-alignment: center"
                alignment = Pos.CENTER
                textProperty().bind(controller.alarmStrings)
            }
        }
    }

    fun updateAll() {
        Platform.runLater {
            matrixTab.refreshTableContent()
            mapTab.paintMap()
        }
    }
}

