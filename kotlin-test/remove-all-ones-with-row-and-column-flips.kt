package removealloneswithrowandcolumnflips

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class RemoveAllOnesWithRowAndColumnFlipsTest {
    @Test
    fun rowsAreEqualOrComplementary() {
        val grid = arrayOf(intArrayOf(0, 1, 0), intArrayOf(1, 0, 1), intArrayOf(0, 1, 0))
        assertTrue(Solution().removeOnes(grid))
    }

    @Test
    fun rowIsNeitherEqualNorComplementary() {
        val grid = arrayOf(intArrayOf(1, 1, 0), intArrayOf(0, 0, 0), intArrayOf(0, 0, 0))
        assertFalse(Solution().removeOnes(grid))
    }

    @Test
    fun singleCell() {
        assertTrue(Solution().removeOnes(arrayOf(intArrayOf(1))))
        assertTrue(Solution().removeOnes(arrayOf(intArrayOf(0))))
    }

    @Test
    fun incompatibleMiddleRow() {
        val grid = arrayOf(intArrayOf(0, 0), intArrayOf(0, 1), intArrayOf(1, 1))
        assertFalse(Solution().removeOnes(grid))
    }
}
