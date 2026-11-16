package binarywatch

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class BinaryWatchTest {
    @Test
    fun noLightsAreOn() {
        assertEquals(listOf("0:00"), Solution().readBinaryWatch(0))
    }

    @Test
    fun oneLightIsOn() {
        val expected = listOf(
            "0:01", "0:02", "0:04", "0:08", "0:16", "0:32",
            "1:00", "2:00", "4:00", "8:00"
        )
        assertEquals(expected, Solution().readBinaryWatch(1))
    }

    @Test
    fun twoLightsAreOn() {
        assertEquals(44, Solution().readBinaryWatch(2).size)
    }

    @Test
    fun impossibleLightCount() {
        assertEquals(emptyList<String>(), Solution().readBinaryWatch(9))
    }
}
