package uniquepathsiii

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class UniquePathsIiiTest {
    @Test
    fun firstLeetCodeExample() {
        val grid = arrayOf(
            intArrayOf(1, 0, 0, 0),
            intArrayOf(0, 0, 0, 0),
            intArrayOf(0, 0, 2, -1)
        )
        assertEquals(2, Solution().uniquePathsIII(grid))
    }

    @Test
    fun secondLeetCodeExample() {
        val grid = arrayOf(
            intArrayOf(1, 0, 0, 0),
            intArrayOf(0, 0, 0, 0),
            intArrayOf(0, 0, 0, 2)
        )
        assertEquals(4, Solution().uniquePathsIII(grid))
    }

    @Test
    fun noPath() {
        val grid = arrayOf(
            intArrayOf(0, 1),
            intArrayOf(2, 0)
        )
        assertEquals(0, Solution().uniquePathsIII(grid))
    }

    @Test
    fun adjacentStartAndEnd() {
        assertEquals(1, Solution().uniquePathsIII(arrayOf(intArrayOf(1, 2))))
    }
}
