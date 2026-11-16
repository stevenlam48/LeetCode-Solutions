package removealloneswithrowandcolumnflipsii

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class RemoveAllOnesWithRowAndColumnFlipsIiTest {
    @Test
    fun standardExample() {
        val grid = arrayOf(intArrayOf(1, 1, 1), intArrayOf(1, 1, 1), intArrayOf(0, 1, 0))
        assertEquals(2, Solution().removeOnes(grid))
    }

    @Test
    fun noOnes() {
        assertEquals(0, Solution().removeOnes(arrayOf(intArrayOf(0))))
    }

    @Test
    fun singleOne() {
        assertEquals(1, Solution().removeOnes(arrayOf(intArrayOf(1))))
    }

    @Test
    fun diagonalOnesNeedTwoFlips() {
        val grid = arrayOf(intArrayOf(1, 0), intArrayOf(0, 1))
        assertEquals(2, Solution().removeOnes(grid))
    }

    @Test
    fun fullTwoByTwoGrid() {
        val grid = arrayOf(intArrayOf(1, 1), intArrayOf(1, 1))
        assertEquals(2, Solution().removeOnes(grid))
    }
}
