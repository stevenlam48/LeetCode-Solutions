package uniquePaths2

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class UniquePaths2Test {
    @Test
    fun threeByTwoGrid() {
        assertEquals(3, Solution().uniquePaths(3, 2))
    }

    @Test
    fun sevenByThreeGrid() {
        assertEquals(28, Solution().uniquePaths(7, 3))
    }

    @Test
    fun squareGrid() {
        assertEquals(20, Solution().uniquePaths(4, 4))
    }

    @Test
    fun oneDimensionalGrid() {
        assertEquals(1, Solution().uniquePaths(1, 10))
        assertEquals(1, Solution().uniquePaths(10, 1))
    }
}
