package mergeintervals

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class MergeIntervalsTest {
    @Test
    fun exampleOne() {
        val intervals = arrayOf(intArrayOf(1, 3), intArrayOf(2, 6), intArrayOf(8, 10), intArrayOf(15, 18))
        val expected = arrayOf(intArrayOf(1, 6), intArrayOf(8, 10), intArrayOf(15, 18))
        assertArrayEquals(expected, Solution().merge(intervals))
    }

    @Test
    fun touchingIntervalsMerge() {
        val intervals = arrayOf(intArrayOf(1, 4), intArrayOf(4, 5))
        assertArrayEquals(arrayOf(intArrayOf(1, 5)), Solution().merge(intervals))
    }

    @Test
    fun nestedAndUnsortedIntervals() {
        val intervals = arrayOf(intArrayOf(8, 10), intArrayOf(1, 9), intArrayOf(2, 5), intArrayOf(12, 14))
        val expected = arrayOf(intArrayOf(1, 10), intArrayOf(12, 14))
        assertArrayEquals(expected, Solution().merge(intervals))
    }

    @Test
    fun emptyInput() {
        assertArrayEquals(emptyArray(), Solution().merge(emptyArray()))
    }
}
