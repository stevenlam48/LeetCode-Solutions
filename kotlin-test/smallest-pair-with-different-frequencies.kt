package smallestpairwithdifferentfrequencies

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class SmallestPairWithDifferentFrequenciesTest {
    private val solution = Solution()

    @Test
    fun choosesSmallestValueWithDifferentFrequency() {
        assertArrayEquals(intArrayOf(1, 3), solution.minDistinctFreqPair(intArrayOf(1, 2, 3, 1, 2)))
    }

    @Test
    fun allFrequenciesAreEqual() {
        assertArrayEquals(intArrayOf(-1, -1), solution.minDistinctFreqPair(intArrayOf(1, 1, 2, 2)))
        assertArrayEquals(intArrayOf(-1, -1), solution.minDistinctFreqPair(intArrayOf(5)))
    }

    @Test
    fun negativeValues() {
        assertArrayEquals(intArrayOf(-2, -1), solution.minDistinctFreqPair(intArrayOf(-2, -2, -1)))
    }
}
