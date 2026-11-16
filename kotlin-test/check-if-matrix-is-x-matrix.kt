package checkifmatrixisxmatrix

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class CheckIfMatrixIsXMatrixTest {
    private val solution = Solution()

    @Test
    fun validXMatrix() {
        assertTrue(solution.checkXMatrix(arrayOf(
            intArrayOf(2, 0, 0, 1),
            intArrayOf(0, 3, 1, 0),
            intArrayOf(0, 5, 2, 0),
            intArrayOf(4, 0, 0, 2)
        )))
    }

    @Test
    fun nonzeroOutsideDiagonals() {
        assertFalse(solution.checkXMatrix(arrayOf(
            intArrayOf(5, 7, 0),
            intArrayOf(0, 3, 1),
            intArrayOf(0, 5, 0)
        )))
    }

    @Test
    fun zeroOnDiagonal() {
        assertFalse(solution.checkXMatrix(arrayOf(intArrayOf(0, 0), intArrayOf(0, 2))))
    }

    @Test
    fun singleValidElement() {
        assertTrue(solution.checkXMatrix(arrayOf(intArrayOf(7))))
    }

    @Test
    fun singleZeroElement() {
        assertFalse(solution.checkXMatrix(arrayOf(intArrayOf(0))))
    }
}
