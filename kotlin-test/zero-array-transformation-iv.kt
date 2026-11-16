package zeroarraytransformationiv

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ZeroArrayTransformationIVTest {
    @Test
    fun impossibleBecauseValueTooLarge() {
        assertEquals(
            -1,
            Solution().minZeroArray(
                intArrayOf(2, 3, 4, 5),
                arrayOf(intArrayOf(0, 2, 1), intArrayOf(1, 3, 1), intArrayOf(0, 3, 1)),
            ),
        )
    }

    @Test
    fun needsAllThreeQueries() {
        assertEquals(
            3,
            Solution().minZeroArray(
                intArrayOf(1, 2, 3, 4),
                arrayOf(intArrayOf(0, 3, 1), intArrayOf(0, 3, 2), intArrayOf(0, 3, 3)),
            ),
        )
    }

    @Test
    fun alreadyZero() {
        assertEquals(
            0,
            Solution().minZeroArray(
                intArrayOf(0, 0),
                arrayOf(intArrayOf(0, 1, 5)),
            ),
        )
    }

    @Test
    fun subsetSumNeedsBothQueries() {
        assertEquals(
            2,
            Solution().minZeroArray(
                intArrayOf(5),
                arrayOf(intArrayOf(0, 0, 2), intArrayOf(0, 0, 3)),
            ),
        )
    }

    @Test
    fun subsetSumImpossible() {
        assertEquals(
            -1,
            Solution().minZeroArray(
                intArrayOf(7),
                arrayOf(intArrayOf(0, 0, 2), intArrayOf(0, 0, 3)),
            ),
        )
    }

    @Test
    fun noQueriesNonZero() {
        assertEquals(-1, Solution().minZeroArray(intArrayOf(1), emptyArray()))
    }
}
