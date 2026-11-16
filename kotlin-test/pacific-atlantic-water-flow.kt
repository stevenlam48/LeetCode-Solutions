package pacificatlanticwaterflow

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class PacificAtlanticWaterFlowTest {
    private val solution = Solution()

    @Test
    fun example() {
        val matrix = arrayOf(
            intArrayOf(1, 2, 2, 3, 5),
            intArrayOf(3, 2, 3, 4, 4),
            intArrayOf(2, 4, 5, 3, 1),
            intArrayOf(6, 7, 1, 4, 5),
            intArrayOf(5, 1, 1, 2, 4)
        )
        val expected = setOf(
            listOf(0, 4), listOf(1, 3), listOf(1, 4), listOf(2, 2),
            listOf(3, 0), listOf(3, 1), listOf(4, 0)
        )
        assertEquals(expected, solution.pacificAtlantic(matrix).map { it.toList() }.toSet())
    }

    @Test
    fun emptyMatrix() {
        assertTrue(solution.pacificAtlantic(emptyArray()).isEmpty())
    }

    @Test
    fun singleCell() {
        val result = solution.pacificAtlantic(arrayOf(intArrayOf(7)))
        assertEquals(listOf(listOf(0, 0)), result.map { it.toList() })
    }

    @Test
    fun increasingGrid() {
        val matrix = arrayOf(intArrayOf(1, 2, 3), intArrayOf(3, 4, 5))
        val expected = setOf(listOf(0, 2), listOf(1, 0), listOf(1, 1), listOf(1, 2))
        assertEquals(expected, solution.pacificAtlantic(matrix).map { it.toList() }.toSet())
    }
}
