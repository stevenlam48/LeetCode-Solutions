package countthenumberofpowerfulintegers
// Time:  O(logf)
// Space: O(1)

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CountTheNumberOfPowerfulIntegersTest {
    @Test
    fun exampleOne() {
        assertEquals(5L, Solution().numberOfPowerfulInt(1L, 6000L, 4, "124"))
    }

    @Test
    fun exampleTwo() {
        assertEquals(2L, Solution().numberOfPowerfulInt(15L, 215L, 6, "10"))
    }

    @Test
    fun suffixLongerThanRangeValues() {
        assertEquals(0L, Solution().numberOfPowerfulInt(1000L, 2000L, 4, "3000"))
    }

    @Test
    fun exactSingleValueRange() {
        assertEquals(1L, Solution().numberOfPowerfulInt(124L, 124L, 4, "124"))
    }
}
