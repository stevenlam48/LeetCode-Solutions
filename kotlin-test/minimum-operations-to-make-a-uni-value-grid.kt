package minimumoperationstomakeaunivaluegrid

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumOperationsToMakeAUniValueGridTest {
    @Test
    fun testUseUpperMedian() {
        assertEquals(
            4,
            Solution().minOperations(arrayOf(intArrayOf(2, 4), intArrayOf(6, 8)), 2)
        )
    }

    @Test
    fun testIncompatibleResidues() {
        assertEquals(-1, Solution().minOperations(arrayOf(intArrayOf(1, 2)), 2))
    }

    @Test
    fun testSingleElement() {
        assertEquals(0, Solution().minOperations(arrayOf(intArrayOf(7)), 3))
    }

    @Test
    fun testOddNumberOfValues() {
        assertEquals(2, Solution().minOperations(arrayOf(intArrayOf(1, 5, 9)), 4))
    }
}
