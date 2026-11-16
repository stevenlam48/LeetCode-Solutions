package filteroccupiedintervals

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FilterOccupiedIntervalsTest {
    private fun check(expected: Array<IntArray>, actual: Array<IntArray>) {
        assertEquals(expected.size, actual.size)
        for (i in expected.indices) {
            assertArrayEquals(expected[i], actual[i])
        }
    }

    @Test
    fun splitsOverlappingInterval() {
        val actual = Solution().filterOccupiedIntervals(
            arrayOf(intArrayOf(1, 3), intArrayOf(5, 7)), 2, 4
        )
        check(arrayOf(intArrayOf(1, 1), intArrayOf(5, 7)), actual)
    }

    @Test
    fun splitsSingleInterval() {
        val actual = Solution().filterOccupiedIntervals(arrayOf(intArrayOf(1, 5)), 2, 3)
        check(arrayOf(intArrayOf(1, 1), intArrayOf(4, 5)), actual)
    }

    @Test
    fun mergesAdjacentIntervals() {
        val actual = Solution().filterOccupiedIntervals(
            arrayOf(intArrayOf(1, 2), intArrayOf(3, 4)), 10, 20
        )
        check(arrayOf(intArrayOf(1, 4)), actual)
    }

    @Test
    fun freeRangeCoversEverything() {
        val actual = Solution().filterOccupiedIntervals(arrayOf(intArrayOf(1, 10)), 1, 10)
        check(emptyArray(), actual)
    }

    @Test
    fun freeRangeBeforeAllIntervals() {
        val actual = Solution().filterOccupiedIntervals(arrayOf(intArrayOf(5, 6)), 1, 4)
        check(arrayOf(intArrayOf(5, 6)), actual)
    }

    @Test
    fun singlePointRemoved() {
        val actual = Solution().filterOccupiedIntervals(arrayOf(intArrayOf(1, 1)), 1, 1)
        check(emptyArray(), actual)
    }
}
