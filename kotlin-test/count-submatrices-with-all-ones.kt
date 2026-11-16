package countsubmatriceswithallones

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class CountSubmatricesWithAllOnesTest {
    private val solution = Solution()

    @Test
    fun `counts all submatrices in an all one matrix`() {
        val mat = arrayOf(intArrayOf(1, 1), intArrayOf(1, 1))
        assertEquals(9, solution.numSubmat(mat))
    }

    @Test
    fun `handles zero cells and gaps`() {
        val diagonal = arrayOf(intArrayOf(1, 0), intArrayOf(0, 1))
        assertEquals(2, solution.numSubmat(diagonal))
        assertEquals(0, solution.numSubmat(arrayOf(intArrayOf(0, 0))))
    }

    @Test
    fun `counts submatrices across several rows and columns`() {
        val mat = arrayOf(
            intArrayOf(0, 1, 1, 0),
            intArrayOf(0, 1, 1, 1),
            intArrayOf(1, 1, 1, 0)
        )
        assertEquals(24, solution.numSubmat(mat))
    }

    @Test
    fun `handles a single cell`() {
        assertEquals(1, solution.numSubmat(arrayOf(intArrayOf(1))))
    }
}
