package minimumintervaltoincludeeachquery

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class MinimumIntervalToIncludeEachQueryTest {
    private val solution = Solution()

    @Test
    fun standardExample() {
        assertArrayEquals(
            intArrayOf(3, 3, 1, 4),
            solution.minInterval(
                arrayOf(intArrayOf(1, 4), intArrayOf(2, 4), intArrayOf(3, 6), intArrayOf(4, 4)),
                intArrayOf(2, 3, 4, 5)
            )
        )
    }

    @Test
    fun queriesOutsideAllIntervals() {
        assertArrayEquals(
            intArrayOf(2, -1, 4, 6),
            solution.minInterval(
                arrayOf(intArrayOf(2, 3), intArrayOf(2, 5), intArrayOf(1, 8), intArrayOf(20, 25)),
                intArrayOf(2, 19, 5, 22)
            )
        )
    }

    @Test
    fun duplicateQueriesRestoreOriginalOrder() {
        assertArrayEquals(
            intArrayOf(2, 4, 2),
            solution.minInterval(
                arrayOf(intArrayOf(1, 2), intArrayOf(1, 4)),
                intArrayOf(2, 4, 2)
            )
        )
    }

    @Test
    fun noIntervalsOrQueries() {
        assertArrayEquals(intArrayOf(-1, -1), solution.minInterval(emptyArray(), intArrayOf(1, 2)))
        assertArrayEquals(IntArray(0), solution.minInterval(arrayOf(intArrayOf(1, 2)), IntArray(0)))
    }
}
