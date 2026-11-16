package countequalanddivisiblepairsinanarray

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CountEqualAndDivisiblePairsInAnArrayTest {
    @Test
    fun example() {
        assertEquals(4, Solution().countPairs(intArrayOf(3, 1, 2, 2, 2, 1, 3), 2))
    }

    @Test
    fun kEqualsOneStillNeedsEqualValues() {
        assertEquals(0, Solution().countPairs(intArrayOf(1, 2, 3, 4), 1))
    }

    @Test
    fun allEqual() {
        assertEquals(5, Solution().countPairs(intArrayOf(1, 1, 1, 1), 2))
    }

    @Test
    fun pair() {
        assertEquals(1, Solution().countPairs(intArrayOf(1, 1), 1))
    }

    @Test
    fun singleElement() {
        assertEquals(0, Solution().countPairs(intArrayOf(1), 1))
    }
}
