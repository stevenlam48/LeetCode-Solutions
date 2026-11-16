package aggregatetwotimeseries

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class AggregateTwoTimeSeriesTest {
    private val solution = Solution()

    @Test
    fun interleavedAndSharedTimestamps() {
        val series1 = arrayOf(intArrayOf(1, 10), intArrayOf(3, 20), intArrayOf(5, 30))
        val series2 = arrayOf(intArrayOf(2, 5), intArrayOf(3, 7), intArrayOf(6, 11))
        assertSeries(
            arrayOf(
                intArrayOf(1, 15), intArrayOf(2, 25), intArrayOf(3, 27),
                intArrayOf(5, 41), intArrayOf(6, 11)
            ),
            solution.aggregateTimeSeries(series1, series2)
        )
    }

    @Test
    fun allTimestampsMatch() {
        val actual = solution.aggregateTimeSeries(
            arrayOf(intArrayOf(1, 4), intArrayOf(2, -2)),
            arrayOf(intArrayOf(1, 3), intArrayOf(2, 8))
        )
        assertSeries(arrayOf(intArrayOf(1, 7), intArrayOf(2, 6)), actual)
    }

    @Test
    fun firstSeriesEmpty() {
        val actual = solution.aggregateTimeSeries(emptyArray(), arrayOf(intArrayOf(4, 9)))
        assertSeries(arrayOf(intArrayOf(4, 9)), actual)
    }

    @Test
    fun disjointSeries() {
        val actual = solution.aggregateTimeSeries(
            arrayOf(intArrayOf(1, 2), intArrayOf(5, 6)),
            arrayOf(intArrayOf(2, 3), intArrayOf(7, 8))
        )
        assertSeries(
            arrayOf(intArrayOf(1, 5), intArrayOf(2, 9), intArrayOf(5, 14), intArrayOf(7, 8)),
            actual
        )
    }
}

private fun assertSeries(expected: Array<IntArray>, actual: Array<IntArray>) {
    assertEquals(expected.size, actual.size)
    for (i in expected.indices) {
        assertArrayEquals(expected[i], actual[i])
    }
}
