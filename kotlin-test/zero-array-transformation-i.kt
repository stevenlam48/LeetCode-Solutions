package zeroarraytransformationi

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class ZeroArrayTransformationITest {
    @Test
    fun example1() {
        assertTrue(
            Solution().isZeroArray(
                intArrayOf(1, 0, 1),
                arrayOf(intArrayOf(0, 2)),
            ),
        )
    }

    @Test
    fun example2() {
        assertFalse(
            Solution().isZeroArray(
                intArrayOf(4, 3, 2, 1),
                arrayOf(intArrayOf(1, 3), intArrayOf(0, 2)),
            ),
        )
    }

    @Test
    fun noQueriesAllZero() {
        assertTrue(Solution().isZeroArray(intArrayOf(0, 0, 0), emptyArray()))
    }

    @Test
    fun noQueriesNonZero() {
        assertFalse(Solution().isZeroArray(intArrayOf(0, 1, 0), emptyArray()))
    }

    @Test
    fun singleElementCovered() {
        assertTrue(
            Solution().isZeroArray(
                intArrayOf(1),
                arrayOf(intArrayOf(0, 0)),
            ),
        )
    }

    @Test
    fun overlappingQueries() {
        assertTrue(
            Solution().isZeroArray(
                intArrayOf(2, 2),
                arrayOf(intArrayOf(0, 1), intArrayOf(0, 1)),
            ),
        )
    }
}
