package findmaximaluncoveredranges

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FindMaximalUncoveredRangesTest {
    private fun assertRanges(expected: Array<IntArray>, actual: Array<IntArray>) {
        assertEquals(expected.size, actual.size)
        for (i in expected.indices) {
            assertArrayEquals(expected[i], actual[i])
        }
    }

    @Test
    fun findsEveryGapBetweenSortedRanges() {
        assertRanges(
            arrayOf(intArrayOf(0, 2), intArrayOf(6, 6), intArrayOf(9, 9)),
            Solution().findMaximalUncoveredRanges(
                10,
                arrayOf(intArrayOf(3, 5), intArrayOf(7, 8))
            )
        )
    }

    @Test
    fun mergesOverlappingRanges() {
        assertRanges(
            arrayOf(intArrayOf(5, 5), intArrayOf(8, 9)),
            Solution().findMaximalUncoveredRanges(
                10,
                arrayOf(intArrayOf(6, 7), intArrayOf(0, 2), intArrayOf(1, 4))
            )
        )
    }

    @Test
    fun handlesEmptyAndFullyCoveringRanges() {
        assertRanges(
            arrayOf(intArrayOf(0, 4)),
            Solution().findMaximalUncoveredRanges(5, arrayOf())
        )
        assertRanges(
            arrayOf(),
            Solution().findMaximalUncoveredRanges(10, arrayOf(intArrayOf(0, 9)))
        )
    }
}
