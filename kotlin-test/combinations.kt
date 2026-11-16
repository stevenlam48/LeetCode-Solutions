package combinations

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CombinationsTest {
    private val solution = Solution()

    private fun toLists(cells: Array<IntArray>): List<List<Int>> = cells.map { it.toList() }

    @Test
    fun testExample1() {
        assertEquals(
            listOf(
                listOf(1, 2), listOf(1, 3), listOf(1, 4),
                listOf(2, 3), listOf(2, 4), listOf(3, 4)
            ),
            toLists(solution.combine(4, 2))
        )
    }

    @Test
    fun testExample2() {
        assertEquals(listOf(listOf(1)), toLists(solution.combine(1, 1)))
    }

    @Test
    fun testKGreaterThanN() {
        assertEquals(emptyList<List<Int>>(), toLists(solution.combine(4, 5)))
    }

    @Test
    fun testKEqualsN() {
        assertEquals(
            listOf(listOf(1, 2, 3)),
            toLists(solution.combine(3, 3))
        )
    }

    @Test
    fun testKEqualsOne() {
        assertEquals(
            listOf(listOf(1), listOf(2), listOf(3)),
            toLists(solution.combine(3, 1))
        )
    }
}
