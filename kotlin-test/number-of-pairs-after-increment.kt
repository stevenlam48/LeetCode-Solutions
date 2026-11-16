package numberofpairsafterincrement

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class NumberOfPairsAfterIncrementTest {
    @Test
    fun countsPairsForMultipleTargets() {
        val queries = arrayOf(intArrayOf(2, 3), intArrayOf(2, 4))
        assertArrayEquals(
            intArrayOf(2, 2),
            Solution().numberOfPairs(intArrayOf(1, 2), intArrayOf(1, 2, 3), queries)
        )
    }

    @Test
    fun updatesRangeWithinOneBlock() {
        val queries = arrayOf(
            intArrayOf(1, 0, 1, 2),
            intArrayOf(2, 4),
            intArrayOf(2, 5)
        )
        assertArrayEquals(
            intArrayOf(2, 1),
            Solution().numberOfPairs(intArrayOf(1), intArrayOf(1, 2, 3), queries)
        )
    }

    @Test
    fun appliesLazyIncrementToInteriorBlock() {
        val queries = arrayOf(
            intArrayOf(1, 1, 8, 2),
            intArrayOf(2, 4)
        )
        assertArrayEquals(
            intArrayOf(8),
            Solution().numberOfPairs(intArrayOf(1), IntArray(10) { 1 }, queries)
        )
    }

    @Test
    fun updatesBlockThatAlreadyHasLazyValue() {
        val queries = arrayOf(
            intArrayOf(1, 1, 6, 1),
            intArrayOf(2, 7),
            intArrayOf(1, 3, 5, 2),
            intArrayOf(2, 9)
        )
        assertArrayEquals(
            intArrayOf(1, 1),
            Solution().numberOfPairs(intArrayOf(2), intArrayOf(1, 2, 3, 4, 5, 6, 7, 8), queries)
        )
    }

    @Test
    fun combinesDuplicateFrequenciesAcrossBlocks() {
        val queries = arrayOf(
            intArrayOf(1, 2, 4, 1),
            intArrayOf(2, 3)
        )
        assertArrayEquals(
            intArrayOf(8),
            Solution().numberOfPairs(intArrayOf(1, 1, 2), IntArray(5) { 1 }, queries)
        )
    }
}
