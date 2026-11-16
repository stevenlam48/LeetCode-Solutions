package minimumoperationstomakeallgridelementsequal

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumOperationsToMakeAllGridElementsEqualTest {
    @Test
    fun testSingleCellOperationsRaiseEveryValueToMaximum() {
        assertEquals(
            4L,
            Solution().minOperations(arrayOf(intArrayOf(1, 3), intArrayOf(2, 2)), 1)
        )
    }

    @Test
    fun testAlreadyEqualGrid() {
        assertEquals(
            0L,
            Solution().minOperations(arrayOf(intArrayOf(4, 4), intArrayOf(4, 4)), 2)
        )
    }

    @Test
    fun testFullGridBlockCannotFixInconsistency() {
        assertEquals(
            -1L,
            Solution().minOperations(arrayOf(intArrayOf(4, 4), intArrayOf(4, 5)), 2)
        )
    }

    @Test
    fun testNegativeValues() {
        assertEquals(2L, Solution().minOperations(arrayOf(intArrayOf(-3, -1)), 1))
    }
}
