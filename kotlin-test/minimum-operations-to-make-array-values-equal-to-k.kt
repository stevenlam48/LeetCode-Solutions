package minimumoperationstomakearrayvaluesequaltok

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumOperationsToMakeArrayValuesEqualToKTest {
    @Test
    fun testKIsPresentAmongDistinctValues() {
        assertEquals(1, Solution().minOperations(intArrayOf(5, 2, 5, 2, 5), 2))
    }

    @Test
    fun testValueBelowK() {
        assertEquals(-1, Solution().minOperations(intArrayOf(4, 1, 3), 2))
    }

    @Test
    fun testSingleDistinctValueAboveK() {
        assertEquals(1, Solution().minOperations(intArrayOf(3, 3, 3), 2))
    }

    @Test
    fun testAlreadyEqualToK() {
        assertEquals(0, Solution().minOperations(intArrayOf(2), 2))
    }
}
