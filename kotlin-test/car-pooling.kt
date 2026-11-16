package carpooling

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class CarPoolingTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        val trips = arrayOf(intArrayOf(2, 1, 5), intArrayOf(3, 3, 7))
        assertFalse(solution.carPooling(trips, 4))
    }

    @Test
    fun testExample2() {
        val trips = arrayOf(intArrayOf(2, 1, 5), intArrayOf(3, 3, 7))
        assertTrue(solution.carPooling(trips, 5))
    }

    @Test
    fun testExample3() {
        val trips = arrayOf(intArrayOf(2, 1, 5), intArrayOf(3, 5, 7))
        assertTrue(solution.carPooling(trips, 3))
    }

    @Test
    fun testNoTrips() {
        assertTrue(solution.carPooling(emptyArray(), 0))
    }

    @Test
    fun testExactCapacity() {
        val trips = arrayOf(intArrayOf(3, 0, 2), intArrayOf(2, 1, 3))
        assertTrue(solution.carPooling(trips, 5))
        assertFalse(solution.carPooling(trips, 4))
    }
}
