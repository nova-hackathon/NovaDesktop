package utils

import common.DistanceInfo
import javafx.application.Platform
import javafx.scene.control.Alert
import javafx.stage.Screen

fun getWindowMinSize(): Pair<Double, Double> {
    val visualBounds = Screen.getPrimary().visualBounds
    val minHeight = visualBounds.height / 2
    val minWidth = visualBounds.width / 2
    return Pair(minHeight, minWidth)
}

fun showAlertDialog(message: String) {
    Platform.runLater {
        val alert = Alert(Alert.AlertType.WARNING)
        alert.title = "Warning"
        alert.headerText = message
        alert.showAndWait()
    }
}
fun showAlarmDialog(message: String,title : String) {
    Platform.runLater {
        val alert = Alert(Alert.AlertType.ERROR)
        alert.title = title
        alert.headerText = message
        alert.showAndWait()
    }
}