package numberofboomerangs

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class NumberOfBoomerangsTest {
    @Test
    fun example1() {
        val points = arrayOf(
            intArrayOf(0, 0),
            intArrayOf(1, 0),
            intArrayOf(2, 0),
        )
        assertEquals(2, Solution().numberOfBoomerangs(points))
    }

    @Test
    fun example2() {
        val points = arrayOf(
            intArrayOf(1, 1),
            intArrayOf(2, 2),
            intArrayOf(3, 3),
        )
        assertEquals(2, Solution().numberOfBoomerangs(points))
    }

    @Test
    fun singlePoint() {
        val points = arrayOf(intArrayOf(1, 1))
        assertEquals(0, Solution().numberOfBoomerangs(points))
    }

    @Test
    fun distinctDistances() {
        val points = arrayOf(
            intArrayOf(0, 0),
            intArrayOf(1, 0),
            intArrayOf(3, 0),
        )
        assertEquals(0, Solution().numberOfBoomerangs(points))
    }

    @Test
    fun collinearPoints() {
        val points = arrayOf(
            intArrayOf(0, 0),
            intArrayOf(1, 0),
            intArrayOf(2, 0),
            intArrayOf(3, 0),
            intArrayOf(4, 0),
        )
        assertEquals(8, Solution().numberOfBoomerangs(points))
    }
}
