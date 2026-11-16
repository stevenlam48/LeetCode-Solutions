package minimumoperationstoformsubsequencewithtargetsum

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class MinimumOperationsToFormSubsequenceWithTargetSumTest {

    @Test
    fun testExample1() {
        assertEquals(1, Solution().minOperations(intArrayOf(1, 2, 8), 7))
    }

    @Test
    fun testExactSum() {
        assertEquals(0, Solution().minOperations(intArrayOf(1, 32, 1, 1), 35))
    }

    @Test
    fun testImpossible() {
        assertEquals(-1, Solution().minOperations(intArrayOf(1, 1, 1), 4))
    }

    @Test
    fun testNoOperationsNeeded() {
        assertEquals(0, Solution().minOperations(intArrayOf(1, 2, 4), 7))
        assertEquals(0, Solution().minOperations(intArrayOf(1, 2, 4), 6))
    }

    @Test
    fun testMultipleSplits() {
        assertEquals(3, Solution().minOperations(intArrayOf(2, 4, 8), 7))
    }

    @Test
    fun testSingleElement() {
        assertEquals(0, Solution().minOperations(intArrayOf(8), 8))
        assertEquals(-1, Solution().minOperations(intArrayOf(8), 9))
    }
}
