package ipo

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class IpoTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertEquals(
            4,
            solution.findMaximizedCapital(2, 0, intArrayOf(1, 2, 3), intArrayOf(0, 1, 1))
        )
    }

    @Test
    fun testExample2() {
        assertEquals(
            6,
            solution.findMaximizedCapital(3, 0, intArrayOf(1, 2, 3), intArrayOf(0, 1, 2))
        )
    }

    @Test
    fun testCannotAffordAny() {
        assertEquals(
            0,
            solution.findMaximizedCapital(1, 0, intArrayOf(1, 2, 3), intArrayOf(1, 1, 2))
        )
    }

    @Test
    fun testZeroProjects() {
        assertEquals(
            5,
            solution.findMaximizedCapital(0, 5, intArrayOf(1, 2, 3), intArrayOf(0, 1, 1))
        )
    }

    @Test
    fun testFewerProjectsThanK() {
        assertEquals(
            3,
            solution.findMaximizedCapital(5, 0, intArrayOf(1, 2), intArrayOf(0, 0))
        )
    }
}
