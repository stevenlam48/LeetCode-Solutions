package kthsmallestinstructions

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class KthSmallestInstructionsTest {
    @Test
    fun examplePath() {
        assertEquals("HHHVV", Solution().kthSmallestPath(intArrayOf(2, 3), 1))
        assertEquals("HVVHH", Solution().kthSmallestPath(intArrayOf(2, 3), 6))
        assertEquals("VVHHH", Solution().kthSmallestPath(intArrayOf(2, 3), 10))
    }

    @Test
    fun horizontalOnly() {
        assertEquals("HHHH", Solution().kthSmallestPath(intArrayOf(0, 4), 1))
    }

    @Test
    fun verticalOnly() {
        assertEquals("VVV", Solution().kthSmallestPath(intArrayOf(3, 0), 1))
    }

    @Test
    fun largerCombinationCounts() {
        assertEquals("HHHHHVVVVV", Solution().kthSmallestPath(intArrayOf(5, 5), 1))
        assertEquals("VVVVVHHHHH", Solution().kthSmallestPath(intArrayOf(5, 5), 252))
    }
}
