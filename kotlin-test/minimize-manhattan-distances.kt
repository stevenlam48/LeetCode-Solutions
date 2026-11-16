package minimizemanhattandistances
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimizeManhattanDistancesTest {
    @Test
    fun example() {
        val points = arrayOf(
            intArrayOf(3, 10),
            intArrayOf(5, 15),
            intArrayOf(10, 2),
            intArrayOf(4, 4)
        )
        assertEquals(12, Solution().minimumDistance(points))
    }

    @Test
    fun collinearPoints() {
        val points = arrayOf(
            intArrayOf(0, 0),
            intArrayOf(1, 1),
            intArrayOf(2, 2),
            intArrayOf(3, 3)
        )
        assertEquals(4, Solution().minimumDistance(points))
    }

    @Test
    fun triangularPoints() {
        val points = arrayOf(intArrayOf(0, 0), intArrayOf(4, 0), intArrayOf(0, 3))
        assertEquals(3, Solution().minimumDistance(points))
    }

    @Test
    fun duplicatePoints() {
        val points = arrayOf(
            intArrayOf(0, 0),
            intArrayOf(0, 0),
            intArrayOf(2, 3),
            intArrayOf(5, 5)
        )
        assertEquals(5, Solution().minimumDistance(points))
    }

    @Test
    fun negativeCoordinates() {
        val points = arrayOf(
            intArrayOf(-10, 0),
            intArrayOf(0, 10),
            intArrayOf(10, 0),
            intArrayOf(0, -10)
        )
        assertEquals(20, Solution().minimumDistance(points))
    }
}
