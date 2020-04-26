import common.RootView
import common.adbInit
import common.adbShutdown
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import tornadofx.App
import tornadofx.launch

fun main() {
    CoroutineScope(Dispatchers.IO).launch { adbInit() }
    launch<Main>()
}

class Main : App(RootView::class) {
    override fun stop() {
        super.stop()
        adbShutdown()
    }
}