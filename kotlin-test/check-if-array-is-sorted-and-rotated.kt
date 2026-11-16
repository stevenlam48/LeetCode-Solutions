package checkifarrayissortedandrotated

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class CheckIfArrayIsSortedAndRotatedTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertTrue(solution.check(intArrayOf(3, 4, 5, 1, 2)))
    }

    @Test
    fun testExample2() {
        assertFalse(solution.check(intArrayOf(2, 1, 3, 4)))
    }

    @Test
    fun testExample3() {
        assertTrue(solution.check(intArrayOf(1, 2, 3)))
    }

    @Test
    fun testAllEqual() {
        assertTrue(solution.check(intArrayOf(1, 1, 1)))
    }

    @Test
    fun testTwoElements() {
        assertTrue(solution.check(intArrayOf(2, 1)))
        assertFalse(solution.check(intArrayOf(1, 3, 2)))
    }
}
