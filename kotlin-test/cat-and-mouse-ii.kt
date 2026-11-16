package catandmouseii

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class CatAndMouseIiTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        val grid = arrayOf("####F", "#C...", "M....")
        assertTrue(solution.canMouseWin(grid, 1, 2))
    }

    @Test
    fun testExample2() {
        val grid = arrayOf("M.C...F")
        assertTrue(solution.canMouseWin(grid, 1, 4))
    }

    @Test
    fun testExample3() {
        val grid = arrayOf("M.C...F")
        assertFalse(solution.canMouseWin(grid, 1, 3))
    }

    @Test
    fun testExample4() {
        val grid = arrayOf("C...#", "...F#", "...#M")
        assertFalse(solution.canMouseWin(grid, 1, 1))
    }

    @Test
    fun testExample5() {
        val grid = arrayOf("...#C", "M....", "...#F")
        assertFalse(solution.canMouseWin(grid, 1, 1))
    }
}
