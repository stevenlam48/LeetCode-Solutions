package carfleetii

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class CarFleetIiTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        val cars = arrayOf(
            intArrayOf(1, 2),
            intArrayOf(2, 1),
            intArrayOf(4, 3),
            intArrayOf(7, 2)
        )
        assertArrayEquals(doubleArrayOf(1.0, -1.0, 3.0, -1.0), solution.getCollisionTimes(cars), 1e-5)
    }

    @Test
    fun testExample2() {
        val cars = arrayOf(
            intArrayOf(3, 4),
            intArrayOf(5, 4),
            intArrayOf(6, 3),
            intArrayOf(9, 1)
        )
        assertArrayEquals(doubleArrayOf(2.0, 1.0, 1.5, -1.0), solution.getCollisionTimes(cars), 1e-5)
    }

    @Test
    fun testSingleCar() {
        val cars = arrayOf(intArrayOf(1, 2))
        assertArrayEquals(doubleArrayOf(-1.0), solution.getCollisionTimes(cars), 1e-5)
    }

    @Test
    fun testNoCollisions() {
        val cars = arrayOf(
            intArrayOf(1, 1),
            intArrayOf(2, 1),
            intArrayOf(3, 1)
        )
        assertArrayEquals(doubleArrayOf(-1.0, -1.0, -1.0), solution.getCollisionTimes(cars), 1e-5)
    }
}
