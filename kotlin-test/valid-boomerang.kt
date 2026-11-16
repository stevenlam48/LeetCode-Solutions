package validboomerang

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class ValidBoomerangTest {
    @Test
    fun nonCollinearPoints() {
        val points = arrayOf(intArrayOf(1, 1), intArrayOf(2, 3), intArrayOf(3, 2))
        assertTrue(Solution().isBoomerang(points))
    }

    @Test
    fun collinearPoints() {
        val points = arrayOf(intArrayOf(1, 1), intArrayOf(2, 2), intArrayOf(3, 3))
        assertFalse(Solution().isBoomerang(points))
    }

    @Test
    fun duplicatePoints() {
        val points = arrayOf(intArrayOf(1, 1), intArrayOf(1, 1), intArrayOf(3, 2))
        assertFalse(Solution().isBoomerang(points))
    }

    @Test
    fun verticalAndHorizontalEdges() {
        val points = arrayOf(intArrayOf(0, 0), intArrayOf(0, 2), intArrayOf(3, 0))
        assertTrue(Solution().isBoomerang(points))
    }
}
