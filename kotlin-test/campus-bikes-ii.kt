package campusbikesii

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class CampusBikesIiTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        val workers = arrayOf(intArrayOf(0, 0), intArrayOf(2, 1))
        val bikes = arrayOf(intArrayOf(1, 2), intArrayOf(3, 3))
        assertEquals(6, solution.assignBikes(workers, bikes))
    }

    @Test
    fun testExample2() {
        val workers = arrayOf(intArrayOf(0, 0), intArrayOf(1, 1), intArrayOf(2, 0))
        val bikes = arrayOf(intArrayOf(1, 0), intArrayOf(2, 2), intArrayOf(2, 1))
        assertEquals(4, solution.assignBikes(workers, bikes))
    }

    @Test
    fun testSingleWorker() {
        val workers = arrayOf(intArrayOf(0, 0))
        val bikes = arrayOf(intArrayOf(5, 5), intArrayOf(1, 1))
        assertEquals(2, solution.assignBikes(workers, bikes))
    }

    @Test
    fun testMoreBikesThanWorkers() {
        val workers = arrayOf(intArrayOf(0, 0), intArrayOf(10, 10))
        val bikes = arrayOf(intArrayOf(1, 1), intArrayOf(9, 9), intArrayOf(100, 100))
        assertEquals(4, solution.assignBikes(workers, bikes))
    }
}
