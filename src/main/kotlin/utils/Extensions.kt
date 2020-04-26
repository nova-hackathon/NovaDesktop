package utils

import com.android.ddmlib.CollectingOutputReceiver
import com.android.ddmlib.IDevice
import kotlin.math.pow

fun Int.pow(pow: Int) = toDouble().pow(pow).toInt()

fun <T> List<T>.getFromTheEnd(indexFromTheEnd: Int): T = get(size - indexFromTheEnd)

fun IDevice.getLogsByTag(tag: String): String {
    val receiver = CollectingOutputReceiver()
    executeShellCommand("logcat -s $tag -d", receiver)
    return receiver.output
}

fun <K, V> HashMap<K, V>.getOrAddDefault(key: K, default: V): V {
    val orDefault = getOrDefault(key, default)
    if (orDefault == default) {
        put(key, orDefault)
    }
    return orDefault
}