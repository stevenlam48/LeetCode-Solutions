package campusbikes

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class CampusBikesTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        val workers = arrayOf(intArrayOf(0, 0), intArrayOf(2, 1))
        val bikes = arrayOf(intArrayOf(1, 2), intArrayOf(3, 3))
        assertArrayEquals(intArrayOf(1, 0), solution.assignBikes(workers, bikes))
    }

    @Test
    fun testExample2() {
        val workers = arrayOf(intArrayOf(0, 0), intArrayOf(1, 1), intArrayOf(2, 0))
        val bikes = arrayOf(intArrayOf(1, 0), intArrayOf(2, 2), intArrayOf(2, 1))
        assertArrayEquals(intArrayOf(0, 2, 1), solution.assignBikes(workers, bikes))
    }

    @Test
    fun testSingleWorker() {
        val workers = arrayOf(intArrayOf(0, 0))
        val bikes = arrayOf(intArrayOf(5, 5), intArrayOf(1, 1))
        assertArrayEquals(intArrayOf(1), solution.assignBikes(workers, bikes))
    }

    @Test
    fun testTieBreaksByWorkerIndex() {
        val workers = arrayOf(intArrayOf(0, 0), intArrayOf(0, 0))
        val bikes = arrayOf(intArrayOf(1, 0), intArrayOf(1, 0))
        assertArrayEquals(intArrayOf(0, 1), solution.assignBikes(workers, bikes))
    }
}
