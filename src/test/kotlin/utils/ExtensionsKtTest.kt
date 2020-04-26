package utils

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class ExtensionsKtTest {

    @Test
    fun powTest() {
        assertEquals(8, 2.pow(3))
        assertEquals(1, 2.pow(0))
        assertEquals(10, 10.pow(1))
    }

    @Test
    fun getFromTheEndTest() {
        val listInt = listOf(1, 2, 3, 4, 5, 6, 7)
        val listString = listOf("1", "2", "3", "4", "5", "6", "7")
        assertEquals(7, listInt.getFromTheEnd(1))
        assertEquals(5, listInt.getFromTheEnd(3))
        assertEquals("7", listString.getFromTheEnd(1))
        assertEquals("5", listString.getFromTheEnd(3))
        assertThrows(ArrayIndexOutOfBoundsException::class.java) { listInt.getFromTheEnd(0) }
        assertThrows(ArrayIndexOutOfBoundsException::class.java) { listInt.getFromTheEnd(10) }
    }

    @Test
    fun getOrAddDefault() {
        val map = hashMapOf<String, Int>()
        assertTrue(map.isEmpty())
        assertEquals(1, map.getOrAddDefault("First", 1))
        assertFalse(map.isEmpty())
        assertEquals(1, map.size)
        assertEquals(1, map["First"])
    }
}