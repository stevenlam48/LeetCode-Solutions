package maximumequalfrequency

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumEqualFrequencyTest {
    @Test
    fun example1() {
        assertEquals(7, Solution().maxEqualFreq(intArrayOf(2, 2, 1, 1, 5, 3, 3, 5)))
    }

    @Test
    fun example2() {
        assertEquals(
            13,
            Solution().maxEqualFreq(intArrayOf(1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4, 5))
        )
    }

    @Test
    fun twoEqualElements() {
        assertEquals(2, Solution().maxEqualFreq(intArrayOf(1, 1)))
    }

    @Test
    fun twoDistinctElements() {
        assertEquals(2, Solution().maxEqualFreq(intArrayOf(1, 2)))
    }

    @Test
    fun twoTriples() {
        assertEquals(5, Solution().maxEqualFreq(intArrayOf(1, 1, 1, 2, 2, 2)))
    }
}
