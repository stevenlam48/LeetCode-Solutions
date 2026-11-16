package longestcycleinagraph

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LongestCycleInAGraphTest {
    private val solution = Solution()

    @Test
    fun standardExample() {
        assertEquals(3, solution.longestCycle(intArrayOf(3, 3, 4, 2, 3)))
    }

    @Test
    fun noCycle() {
        assertEquals(-1, solution.longestCycle(intArrayOf(2, -1, 3, 1)))
    }

    @Test
    fun selfCycle() {
        assertEquals(1, solution.longestCycle(intArrayOf(0, -1, -1)))
    }

    @Test
    fun longestOfMultipleCycles() {
        assertEquals(4, solution.longestCycle(intArrayOf(1, 0, 3, 4, 5, 2)))
    }
}
