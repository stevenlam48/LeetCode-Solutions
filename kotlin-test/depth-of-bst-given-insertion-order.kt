package depthofbstgiveninsertionorder

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class DepthOfBstGivenInsertionOrderTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertEquals(3, solution.maxDepthBST(intArrayOf(2, 1, 4, 3)))
    }

    @Test
    fun testExample2() {
        assertEquals(3, solution.maxDepthBST(intArrayOf(2, 1, 3, 4)))
    }

    @Test
    fun testExample3() {
        assertEquals(4, solution.maxDepthBST(intArrayOf(1, 2, 3, 4)))
    }

    @Test
    fun testSingleElement() {
        assertEquals(1, solution.maxDepthBST(intArrayOf(5)))
    }

    @Test
    fun testDescending() {
        assertEquals(4, solution.maxDepthBST(intArrayOf(4, 3, 2, 1)))
    }
}
