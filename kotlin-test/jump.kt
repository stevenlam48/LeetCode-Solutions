package jump

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class JumpTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertEquals(2, solution.jump(intArrayOf(2, 3, 1, 1, 4), 5))
    }

    @Test
    fun testExample2() {
        assertEquals(2, solution.jump(intArrayOf(2, 3, 0, 1, 4), 5))
    }

    @Test
    fun testSingleElement() {
        assertEquals(0, solution.jump(intArrayOf(0), 1))
    }

    @Test
    fun testTwoElements() {
        assertEquals(1, solution.jump(intArrayOf(1, 2), 2))
        assertEquals(1, solution.jump(intArrayOf(2, 1), 2))
    }

    @Test
    fun testAllOnes() {
        assertEquals(4, solution.jump(intArrayOf(1, 1, 1, 1, 1), 5))
    }
}
