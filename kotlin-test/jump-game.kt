package jumpgame

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class JumpGameTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertTrue(solution.canJump(intArrayOf(2, 3, 1, 1, 4)))
    }

    @Test
    fun testExample2() {
        assertFalse(solution.canJump(intArrayOf(3, 2, 1, 0, 4)))
    }

    @Test
    fun testSingleElement() {
        assertTrue(solution.canJump(intArrayOf(0)))
        assertTrue(solution.canJump(intArrayOf(1)))
    }

    @Test
    fun testStuckAtStart() {
        assertFalse(solution.canJump(intArrayOf(0, 1)))
    }

    @Test
    fun testZerosInMiddle() {
        assertTrue(solution.canJump(intArrayOf(2, 0, 0)))
    }
}
