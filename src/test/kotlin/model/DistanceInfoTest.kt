package model

import common.DistanceInfo
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class DistanceInfoTest {

    @Test
    fun getDistanceToPhoneByNameOrDefault() {
        val first = DistanceInfo("Name_2", LinkedHashMap(),false,73,95)
        assertTrue(first.distanceMap.isEmpty())
        assertEquals(-1, first.getDistanceToPhoneByNameOrDefault("Random"))
        assertEquals(-999, first.getDistanceToPhoneByNameOrDefault("Random", -999))

        val second = DistanceInfo("Name_2", linkedMapOf("D1" to 1313, "D2" to 444),false,75,98)
        assertFalse(second.distanceMap.isEmpty())
        assertEquals(-1, second.getDistanceToPhoneByNameOrDefault("Random"))
        assertEquals(-999, second.getDistanceToPhoneByNameOrDefault("Random", -999))
        assertEquals(1313, second.getDistanceToPhoneByNameOrDefault("D1"))
        assertEquals(444, second.getDistanceToPhoneByNameOrDefault("D2", -999))

    }
}