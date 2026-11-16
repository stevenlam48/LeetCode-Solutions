package rabbitsinforest

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class RabbitsInForestTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertEquals(5, solution.numRabbits(intArrayOf(1, 1, 2)))
    }

    @Test
    fun testExample2() {
        assertEquals(11, solution.numRabbits(intArrayOf(10, 10, 10)))
    }

    @Test
    fun testEmpty() {
        assertEquals(0, solution.numRabbits(intArrayOf()))
    }

    @Test
    fun testAllZero() {
        assertEquals(3, solution.numRabbits(intArrayOf(0, 0, 0)))
    }

    @Test
    fun testGrouping() {
        assertEquals(6, solution.numRabbits(intArrayOf(2, 2, 2, 2, 2)))
    }
}
