package pascalstriangle

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class PascalsTriangleTest {
    private val solution = Solution()

    @Test
    fun generatesFiveRows() {
        val expected = arrayOf(
            intArrayOf(1),
            intArrayOf(1, 1),
            intArrayOf(1, 2, 1),
            intArrayOf(1, 3, 3, 1),
            intArrayOf(1, 4, 6, 4, 1)
        )
        val actual = solution.generate(5)
        assertArrayEquals(expected, actual)
    }

    @Test
    fun generatesSingleRow() {
        val actual = solution.generate(1)
        assertEquals(1, actual.size)
        assertArrayEquals(intArrayOf(1), actual[0])
    }

    @Test
    fun generatesNoRows() {
        assertEquals(0, solution.generate(0).size)
    }
}
