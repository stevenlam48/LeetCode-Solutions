package uniquePaths

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class UniquePathsTest {
    @Test
    fun threeByTwoGrid() {
        assertEquals(3, Solution().uniquePaths(3, 2))
    }

    @Test
    fun sevenByThreeGrid() {
        assertEquals(28, Solution().uniquePaths(7, 3))
    }

    @Test
    fun oneDimensionalGrid() {
        assertEquals(1, Solution().uniquePaths(1, 10))
        assertEquals(1, Solution().uniquePaths(10, 1))
    }

    @Test
    fun zeroDimension() {
        assertEquals(0, Solution().uniquePaths(0, 5))
        assertEquals(0, Solution().uniquePaths(5, 0))
    }
}
