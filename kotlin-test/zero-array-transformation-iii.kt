package zeroarraytransformationiii

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ZeroArrayTransformationIIITest {
    @Test
    fun example1() {
        assertEquals(
            1,
            Solution().maxRemoval(
                intArrayOf(2, 0, 2),
                arrayOf(intArrayOf(0, 2), intArrayOf(0, 2), intArrayOf(1, 1)),
            ),
        )
    }

    @Test
    fun example2() {
        assertEquals(
            2,
            Solution().maxRemoval(
                intArrayOf(1, 1, 1, 1),
                arrayOf(
                    intArrayOf(1, 3),
                    intArrayOf(0, 2),
                    intArrayOf(1, 3),
                    intArrayOf(1, 2),
                ),
            ),
        )
    }

    @Test
    fun example3() {
        assertEquals(
            -1,
            Solution().maxRemoval(
                intArrayOf(1, 2, 3, 4),
                arrayOf(intArrayOf(0, 3)),
            ),
        )
    }

    @Test
    fun allZeroKeepsEveryQuery() {
        assertEquals(
            2,
            Solution().maxRemoval(
                intArrayOf(0, 0),
                arrayOf(intArrayOf(0, 1), intArrayOf(0, 0)),
            ),
        )
    }

    @Test
    fun noQueriesNeeded() {
        assertEquals(0, Solution().maxRemoval(intArrayOf(0), emptyArray()))
    }

    @Test
    fun noQueriesButNeeded() {
        assertEquals(-1, Solution().maxRemoval(intArrayOf(1), emptyArray()))
    }
}
