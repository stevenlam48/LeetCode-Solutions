package countsubmatriceswithequalfrequencyofxandy

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class CountSubmatricesWithEqualFrequencyOfXAndYTest {
    private val solution = Solution()

    @Test
    fun `counts standard example anchored at the top left`() {
        val grid = arrayOf(charArrayOf('X', 'Y', '.'), charArrayOf('Y', '.', '.'))
        assertEquals(3, solution.numberOfSubmatrices(grid))
    }

    @Test
    fun `includes the full matrix when frequencies are equal`() {
        val grid = arrayOf(charArrayOf('X', 'Y'), charArrayOf('Y', 'X'))
        assertEquals(3, solution.numberOfSubmatrices(grid))
    }

    @Test
    fun `allows the top left element to be y`() {
        assertEquals(1, solution.numberOfSubmatrices(arrayOf(charArrayOf('Y', 'X'))))
    }

    @Test
    fun `excludes matrices with no y`() {
        val grid = arrayOf(charArrayOf('X', '.'), charArrayOf('.', 'X'))
        assertEquals(0, solution.numberOfSubmatrices(grid))
    }

    @Test
    fun `excludes a single symbol`() {
        assertEquals(0, solution.numberOfSubmatrices(arrayOf(charArrayOf('X'))))
        assertEquals(0, solution.numberOfSubmatrices(arrayOf(charArrayOf('Y'))))
    }
}
