package json

import com.google.gson.JsonSyntaxException
import jsonExample
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import singleObjectJson
import singleSecongObjectJson
import utils.getFromTheEnd

internal class JsonParserKtTest {

    private val exampleJson = jsonExample

    @Test
    fun parsePhoneOutputTest() {
        val parsed = parsePhoneOutput(exampleJson)
        assertFalse(parsed.isEmpty())
        assertEquals(15, parsed.size)
        assertTrue(parsed.last().distanceList.isEmpty())
        assertEquals("RED_002", parsed.first().phoneName)
        assertEquals(15, parsed.first().distanceList.size)

        val emptyParsed = parsePhoneOutput("")
        assertTrue(emptyParsed.isEmpty())

        val incorrectJson = parsePhoneOutput("json\njson\njson\njson")
        assertTrue(incorrectJson.isEmpty())
    }

    @Test
    fun convertJsonToObjectTest() {
        val emptyList = convertJsonToObject(emptyList())
        assertTrue(emptyList.isEmpty())

        val correct = convertJsonToObject(getNormalizedOutput(getLastJsonFromLogcat(exampleJson)))
        assertFalse(correct.isEmpty())
        assertEquals(15, correct.size)
        assertTrue(correct.last().distanceList.isEmpty())
        assertEquals("RED_002", correct.first().phoneName)
        assertEquals(15, correct.first().distanceList.size)
    }

    @Test
    fun convertToDistanceListAndNormalizeTest() {
        val parsed = parsePhoneOutput(exampleJson)
        assertTrue(parsed.getFromTheEnd(1).distanceList.isEmpty())
        val converted = convertToDistanceListAndNormalize(parsed)
        assertEquals(parsed.size, converted.first.size)
        assertFalse(converted.first.getFromTheEnd(1).distanceMap.isEmpty())
    }

    @Test
    fun getLastJsonFromLogcatTest() {
        val lastOutput = getLastJsonFromLogcat("")
        assertTrue(lastOutput.isEmpty())

        val incorrectJson = getLastJsonFromLogcat("json\njson\njson\njson")
        assertTrue(incorrectJson.isEmpty())

        val exampleJson = getLastJsonFromLogcat(exampleJson)
        assertFalse(exampleJson.isEmpty())
        assertEquals(17, exampleJson.size)
        assertTrue(exampleJson.first().contains("StartJson"))
        assertTrue(exampleJson.getFromTheEnd(1).contains("EndJson"))
    }

    @Test
    fun getNormalizedOutputTest() {
        val normalized = getNormalizedOutput(getLastJsonFromLogcat(exampleJson))
        assertFalse(normalized.isEmpty())
        assertEquals(15, normalized.size)
        normalized.forEach {
            assertTrue(it.startsWith("{"))
            assertTrue(it.endsWith("}"))
        }

        val empty = getNormalizedOutput(emptyList())
        assertTrue(empty.isEmpty())

        val normalizeNormalized = getNormalizedOutput(normalized)
        assertTrue(normalizeNormalized.isNotEmpty())
        assertEquals(normalized, normalizeNormalized)

        val incorrectLogs = getNormalizedOutput(listOf("incorrect", "incorrect", "incorrect", "incorrect"))
        assertTrue(incorrectLogs.isEmpty())
    }

    @Test
    fun isCorrectJsonTest() {
    }

    @Test
    fun removeLogsMetaTest() {
        val emptyLine = removeLogsMeta("")
        assertTrue(emptyLine.isEmpty())

        val noMeta = "Some line without meta"
        val lineWithoutMeta = removeLogsMeta(noMeta)
        assertEquals(noMeta, lineWithoutMeta)

        val meta = removeLogsMeta("JSON_RTT: $noMeta")
        assertEquals(noMeta, meta)
    }

    @Test
    fun getLastJsonStartIndexTest() {
        val empty = getLastJsonStartIndex(emptyList())
        assertEquals(-1, empty)

        val example = getLastJsonStartIndex(exampleJson.split("\n"))
        assertEquals(36, example)

        val listWithoutStart = getLastJsonStartIndex(listOf("NotStart", "NotStart", "NotStart", "NotStart", "NotStart"))
        assertEquals(-1, listWithoutStart)

        val listWithStart = getLastJsonStartIndex(listOf("NotStart", "NotStart", "StartJson", "NotStart", "NotStart"))
        assertEquals(2, listWithStart)
    }

    @Test
    fun parseJsonTest() {
        assertThrows(IllegalStateException::class.java) { parseJson("") }
        assertThrows(JsonSyntaxException::class.java) { parseJson("{error}") }
        val correct = parseJson(singleObjectJson)
        val expectedObject = JsonDistances(emptyList(), false,"747581e7a57405c3", "RED_003", 75,90)
        assertEquals(expectedObject, correct)
        val secCorrect = parseJson(singleSecongObjectJson)
        val secExpected = JsonDistances(
            listOf(
                Distance(distance = -1, phoneName = "GRN_002"),
                Distance(distance = -1, phoneName = "RED_003"),
                Distance(distance = 10750, phoneName = "BLU_003"),
                Distance(distance = 5375, phoneName = "GRN_001"),
                Distance(distance = 11375, phoneName = "GRN_003"),
                Distance(distance = 10500, phoneName = "BLU_005"),
                Distance(distance = 18750, phoneName = "BLU_006"),
                Distance(distance = 11812, phoneName = "BLU_001"),
                Distance(distance = 14375, phoneName = "RED_004"),
                Distance(distance = 11250, phoneName = "GRN_004"),
                Distance(distance = -1, phoneName = "BLU_002"),
                Distance(distance = -1, phoneName = "RED_002"),
                Distance(distance = 13937, phoneName = "BLU_004"),
                Distance(distance = 9562, phoneName = "RED_001"),
                Distance(distance = 7187, phoneName = "GRN_005"),
                Distance(distance = 12437, phoneName = "GRN_006")
            ), phoneId = "81dec5983097638b", phoneName = "RED_005", isAlarm = false,pulse = 70,pulseOx = 95
        )
        assertEquals(secExpected, secCorrect)
    }
}