package json

import junit.framework.Assert.assertFalse
import junit.framework.Assert.assertTrue
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class JsonDistancesTest {

    @Test
    fun findDistanceByPhoneName() {
        val dist = JsonDistances(
            listOf(
                Distance(14, "phone1"),
                Distance(15, "phone2"),
                Distance(16, "phone3")
            ),
            false,
            "phoneId",
            "phoneName",72,98
        )
        Assertions.assertEquals(Distance(14, "phone1"), dist.findDistanceByPhoneName("phone1"))
        Assertions.assertEquals(Distance(15, "phone2"), dist.findDistanceByPhoneName("phone2"))
        Assertions.assertEquals(Distance(16, "phone3"), dist.findDistanceByPhoneName("phone3"))
        Assertions.assertEquals(Distance(-1, "unknown"), dist.findDistanceByPhoneName("unknown"))
    }

    @Test
    fun hasDifferentName() {
        val firstDistance = JsonDistances(emptyList(), false,"phoneId", "phone1", 72,98)
        val secondDistance = JsonDistances(emptyList(), false,"phoneIdId", "phone2", 72,98)
        val thirdDistance = JsonDistances(emptyList(), false,"phoneIdIdId", "phone1",72,98)
        assertTrue(firstDistance.hasDifferentName(secondDistance))
        assertTrue(secondDistance.hasDifferentName(thirdDistance))
        assertFalse(firstDistance.hasDifferentName(thirdDistance))
    }
}