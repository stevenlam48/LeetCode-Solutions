package countfertilepyramidsinaland

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CountFertilePyramidsInALandTest {
    @Test
    fun exampleOne() {
        val grid = arrayOf(
            intArrayOf(0, 1, 1, 0),
            intArrayOf(1, 1, 1, 1)
        )
        assertEquals(2, Solution().countPyramids(grid))
    }

    @Test
    fun exampleTwo() {
        val grid = arrayOf(
            intArrayOf(1, 1, 1),
            intArrayOf(1, 1, 1)
        )
        assertEquals(2, Solution().countPyramids(grid))
    }

    @Test
    fun exampleThree() {
        val grid = arrayOf(
            intArrayOf(1, 1, 1, 1, 0),
            intArrayOf(1, 1, 1, 1, 1),
            intArrayOf(1, 1, 1, 1, 1),
            intArrayOf(0, 1, 0, 0, 1)
        )
        assertEquals(13, Solution().countPyramids(grid))
    }

    @Test
    fun singleCell() {
        assertEquals(0, Solution().countPyramids(arrayOf(intArrayOf(0))))
        assertEquals(0, Solution().countPyramids(arrayOf(intArrayOf(1))))
    }

    @Test
    fun singleRow() {
        assertEquals(0, Solution().countPyramids(arrayOf(intArrayOf(1, 0, 1))))
    }
}
