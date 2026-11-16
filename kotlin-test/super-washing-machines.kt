package superwashingmachines

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class SuperWashingMachinesTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertEquals(3, solution.findMinMoves(intArrayOf(1, 0, 5)))
    }

    @Test
    fun testExample2() {
        assertEquals(2, solution.findMinMoves(intArrayOf(0, 3, 0)))
    }

    @Test
    fun testExample3() {
        assertEquals(-1, solution.findMinMoves(intArrayOf(0, 2, 0)))
    }

    @Test
    fun testAlreadyBalanced() {
        assertEquals(0, solution.findMinMoves(intArrayOf(2, 2, 2)))
    }

    @Test
    fun testSingleMachine() {
        assertEquals(0, solution.findMinMoves(intArrayOf(5)))
    }
}
