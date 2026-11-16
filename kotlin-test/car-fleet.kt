package carfleet

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class CarFleetTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertEquals(3, solution.carFleet(12, intArrayOf(10, 8, 0, 5, 3), intArrayOf(2, 4, 1, 1, 3)))
    }

    @Test
    fun testSingleCar() {
        assertEquals(1, solution.carFleet(10, intArrayOf(3), intArrayOf(3)))
    }

    @Test
    fun testAllMerge() {
        assertEquals(1, solution.carFleet(100, intArrayOf(0, 2, 4), intArrayOf(4, 2, 1)))
    }

    @Test
    fun testNoMerge() {
        assertEquals(2, solution.carFleet(10, intArrayOf(0, 5), intArrayOf(1, 1)))
    }
}
