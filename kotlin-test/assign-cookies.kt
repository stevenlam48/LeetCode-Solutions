package assigncookies

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class AssignCookiesTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertEquals(1, solution.findContentChildren(intArrayOf(1, 2, 3), intArrayOf(1, 1)))
    }

    @Test
    fun testExample2() {
        assertEquals(2, solution.findContentChildren(intArrayOf(1, 2), intArrayOf(1, 2, 3)))
    }

    @Test
    fun testNoCookies() {
        assertEquals(0, solution.findContentChildren(intArrayOf(1, 2), intArrayOf()))
    }

    @Test
    fun testNoChildren() {
        assertEquals(0, solution.findContentChildren(intArrayOf(), intArrayOf(1, 2)))
    }

    @Test
    fun testExactMatch() {
        assertEquals(3, solution.findContentChildren(intArrayOf(3, 1, 2), intArrayOf(3, 2, 1)))
    }
}
