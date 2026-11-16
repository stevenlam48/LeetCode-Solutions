package concatenationofconsecutivebinarynumbers

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ConcatenationOfConsecutiveBinaryNumbersTest {
    @Test
    fun handlesSingleValue() {
        assertEquals(1, Solution().concatenatedBinary(1))
    }

    @Test
    fun concatenatesThroughPowersOfTwo() {
        assertEquals(27, Solution().concatenatedBinary(3))
        assertEquals(220, Solution().concatenatedBinary(4))
    }

    @Test
    fun appliesModulo() {
        assertEquals(505379714, Solution().concatenatedBinary(12))
    }
}
