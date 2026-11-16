package catandmouse

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class CatAndMouseTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        val graph = arrayOf(
            intArrayOf(2, 5),
            intArrayOf(3),
            intArrayOf(0, 4, 5),
            intArrayOf(1, 4, 5),
            intArrayOf(2, 3),
            intArrayOf(0, 2, 3)
        )
        assertEquals(0, solution.catMouseGame(graph))
    }

    @Test
    fun testExample2() {
        val graph = arrayOf(
            intArrayOf(1, 3),
            intArrayOf(0),
            intArrayOf(3),
            intArrayOf(0, 2)
        )
        assertEquals(1, solution.catMouseGame(graph))
    }

    @Test
    fun testExample3() {
        val graph = arrayOf(
            intArrayOf(2, 3),
            intArrayOf(3, 4),
            intArrayOf(0, 4),
            intArrayOf(0, 1),
            intArrayOf(1, 2)
        )
        assertEquals(1, solution.catMouseGame(graph))
    }
}
