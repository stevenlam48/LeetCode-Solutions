package zeroarraytransformationii

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ZeroArrayTransformationIITest {
    @Test
    fun example1() {
        assertEquals(
            2,
            Solution().minZeroArray(
                intArrayOf(2, 0, 2),
                arrayOf(intArrayOf(0, 2, 1), intArrayOf(0, 2, 1), intArrayOf(1, 1, 3)),
            ),
        )
    }

    @Test
    fun example2() {
        assertEquals(
            -1,
            Solution().minZeroArray(
                intArrayOf(4, 3, 2, 1),
                arrayOf(intArrayOf(1, 3, 2), intArrayOf(0, 2, 1)),
            ),
        )
    }

    @Test
    fun example3() {
        assertEquals(
            -1,
            Solution().minZeroArray(
                intArrayOf(1, 2, 3, 4),
                arrayOf(intArrayOf(0, 3, 1)),
            ),
        )
    }

    @Test
    fun alreadyZero() {
        assertEquals(
            0,
            Solution().minZeroArray(
                intArrayOf(0, 0, 0),
                arrayOf(intArrayOf(0, 2, 1)),
            ),
        )
    }

    @Test
    fun noQueriesNonZero() {
        assertEquals(-1, Solution().minZeroArray(intArrayOf(1), emptyArray()))
    }

    @Test
    fun singleQuerySuffices() {
        assertEquals(
            1,
            Solution().minZeroArray(
                intArrayOf(3, 3),
                arrayOf(intArrayOf(0, 1, 3)),
            ),
        )
    }
}
