package minimumoperationstomakearrayequaltotarget

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumOperationsToMakeArrayEqualToTargetTest {
    @Test
    fun testPositiveAndNegativeDifferences() {
        assertEquals(
            4L,
            Solution().minimumOperations(
                intArrayOf(3, 1, 1, 2),
                intArrayOf(2, 1, 4, 5)
            )
        )
    }

    @Test
    fun testSinglePositiveIncrease() {
        assertEquals(
            2L,
            Solution().minimumOperations(intArrayOf(1, 1, 1), intArrayOf(1, 3, 2))
        )
    }

    @Test
    fun testNegativeDifferences() {
        assertEquals(
            3L,
            Solution().minimumOperations(intArrayOf(2, 3, 1), intArrayOf(0, 0, 0))
        )
    }

    @Test
    fun testAlreadyEqual() {
        assertEquals(
            0L,
            Solution().minimumOperations(intArrayOf(1, 2, 3), intArrayOf(1, 2, 3))
        )
    }
}
