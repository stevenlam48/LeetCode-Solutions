package greatestcommondivisortraversal

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class GreatestCommonDivisorTraversalTest {
    @Test
    fun `standard examples`() {
        val solution = Solution()
        assertTrue(solution.canTraverseAllPairs(intArrayOf(2, 3, 6)))
        assertFalse(solution.canTraverseAllPairs(intArrayOf(3, 9, 5)))
        assertTrue(solution.canTraverseAllPairs(intArrayOf(4, 3, 12, 8)))
    }

    @Test
    fun `single element is trivially traversable`() {
        val solution = Solution()
        assertTrue(solution.canTraverseAllPairs(intArrayOf(1)))
        assertTrue(solution.canTraverseAllPairs(intArrayOf(7)))
    }

    @Test
    fun `shared large prime factor connects pair`() {
        assertTrue(Solution().canTraverseAllPairs(intArrayOf(99991, 99991)))
    }
}
