package maximumvalueofanalternatingsequence

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumValueOfAnAlternatingSequenceTest {
    @Test
    fun oddLengths() {
        assertEquals(7L, Solution().maximumValue(1, 7, 3))
        assertEquals(10L, Solution().maximumValue(3, 7, 3))
        assertEquals(12L, Solution().maximumValue(5, 7, 3))
    }

    @Test
    fun evenLengths() {
        assertEquals(10L, Solution().maximumValue(2, 7, 3))
        assertEquals(12L, Solution().maximumValue(4, 7, 3))
    }

    @Test
    fun negativeParameters() {
        assertEquals(-16L, Solution().maximumValue(6, -2, -4))
    }
}
