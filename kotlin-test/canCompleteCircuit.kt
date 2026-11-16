package canCompleteCircuit

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class CanCompleteCircuitTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertEquals(3, solution.canCompleteCircuit(intArrayOf(1, 2, 3, 4, 5), intArrayOf(3, 4, 5, 1, 2)))
    }

    @Test
    fun testExample2() {
        assertEquals(-1, solution.canCompleteCircuit(intArrayOf(2, 3, 4), intArrayOf(3, 4, 3)))
    }

    @Test
    fun testSingleStation() {
        assertEquals(0, solution.canCompleteCircuit(intArrayOf(5), intArrayOf(4)))
        assertEquals(-1, solution.canCompleteCircuit(intArrayOf(2), intArrayOf(3)))
    }

    @Test
    fun testStartAtZero() {
        assertEquals(0, solution.canCompleteCircuit(intArrayOf(3, 1, 1), intArrayOf(1, 2, 2)))
    }
}
