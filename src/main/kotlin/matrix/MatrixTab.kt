package matrix

import common.DistanceInfo
import common.RootController
import javafx.beans.property.ReadOnlyObjectWrapper
import javafx.beans.value.ObservableValue
import javafx.scene.control.TableColumn
import javafx.scene.control.TableRow
import javafx.scene.control.TableView
import tornadofx.*

class MatrixTab : View("Matrix") {
    private var tableView: TableView<DistanceInfo> by singleAssign()
    private val controller: RootController by inject()

    override val root = vbox {
        tableView = tableview {
            items = controller.distances.asObservable()
            setRowFactory {
                object : TableRow<DistanceInfo?>() {
                    override fun updateItem(distanceInfo: DistanceInfo?, empty: Boolean) {
                        super.updateItem(distanceInfo, empty)
                        distanceInfo?.let {
                            if (distanceInfo.isAlarm) {
                                style = "-fx-background-color:red"
                            }
                        }

                    }
                }

            }
        }
    }

    init {
        generateColumns()
    }

    fun refreshTableContent() {
        generateColumns()
        tableView.refresh()
    }

    private fun generateColumns() {
        tableView.columns.clear()
        val columnNames = tableView.items.map { it.phoneName }
        tableView.readonlyColumn("ID", DistanceInfo::phoneName)
        tableView.readonlyColumn("Pulse",DistanceInfo::pulse)
        tableView.readonlyColumn("PulseOx",DistanceInfo::pulseOx)
        columnNames.forEach { columnName ->
            val column = TableColumn<DistanceInfo, Int>(columnName)
            column.setCellValueFactory(::fillRowWithData)
            tableView.columns.add(column)
        }
    }

    private fun fillRowWithData(data: TableColumn.CellDataFeatures<DistanceInfo, Int>): ObservableValue<Int> {
        val distance = getDistanceByName(data.value, data.tableColumn.text) / 1000
        return ReadOnlyObjectWrapper(distance)
    }

    private fun getDistanceByName(distanceInfo: DistanceInfo, phoneName: String, defaultValue: Int = -1) =
        distanceInfo.getDistanceToPhoneByNameOrDefault(phoneName, defaultValue)


}