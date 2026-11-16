package colorthetrianglered

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class ColorTheTriangleRedTest {
    private val solution = Solution()

    private fun toLists(cells: Array<IntArray>): List<List<Int>> = cells.map { it.toList() }

    @Test
    fun testN1() {
        assertEquals(listOf(listOf(1, 1)), toLists(solution.colorRed(1)))
    }

    @Test
    fun testN2() {
        assertEquals(listOf(listOf(1, 1), listOf(2, 1), listOf(2, 3)), toLists(solution.colorRed(2)))
    }

    @Test
    fun testN3() {
        assertEquals(
            listOf(listOf(1, 1), listOf(2, 2), listOf(3, 1), listOf(3, 3), listOf(3, 5)),
            toLists(solution.colorRed(3))
        )
    }

    @Test
    fun testN4() {
        assertEquals(
            listOf(
                listOf(1, 1), listOf(2, 3), listOf(3, 2),
                listOf(4, 1), listOf(4, 3), listOf(4, 5), listOf(4, 7)
            ),
            toLists(solution.colorRed(4))
        )
    }

    @Test
    fun testCoordinatesAreValid() {
        for (n in 1..10) {
            val cells = solution.colorRed(n)
            for (cell in cells) {
                val (i, j) = cell
                assertTrue(i in 1..n)
                assertTrue(j in 1 until 2 * i)
            }
        }
    }
}
