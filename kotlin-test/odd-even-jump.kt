package oddevenjump

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class OddEvenJumpTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertEquals(2, solution.oddEvenJumps(intArrayOf(10, 13, 12, 14, 15)))
    }

    @Test
    fun testExample2() {
        assertEquals(3, solution.oddEvenJumps(intArrayOf(2, 3, 1, 1, 4)))
    }

    @Test
    fun testExample3() {
        assertEquals(3, solution.oddEvenJumps(intArrayOf(5, 1, 3, 4, 2)))
    }

    @Test
    fun testSingleElement() {
        assertEquals(1, solution.oddEvenJumps(intArrayOf(7)))
    }

    @Test
    fun testAllEqual() {
        assertEquals(5, solution.oddEvenJumps(intArrayOf(1, 1, 1, 1, 1)))
    }
}
