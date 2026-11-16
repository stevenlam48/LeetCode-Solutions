package squaresofasortedarray

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class SquaresOfASortedArrayTest {
    private val solution = Solution()

    @Test
    fun sortsSquaresFromBothSidesOfZero() {
        assertArrayEquals(
            intArrayOf(0, 1, 9, 16, 100),
            solution.sortedSquares(intArrayOf(-4, -1, 0, 3, 10))
        )
    }

    @Test
    fun keepsDuplicateSquaresInSortedOrder() {
        assertArrayEquals(
            intArrayOf(4, 9, 9, 49, 121),
            solution.sortedSquares(intArrayOf(-7, -3, 2, 3, 11))
        )
    }

    @Test
    fun handlesEmptyInput() {
        assertArrayEquals(intArrayOf(), solution.sortedSquares(intArrayOf()))
    }

    @Test
    fun handlesSingleNegativeValue() {
        assertArrayEquals(intArrayOf(25), solution.sortedSquares(intArrayOf(-5)))
    }

    @Test
    fun handlesDuplicateNegativesAndZeros() {
        assertArrayEquals(
            intArrayOf(0, 0, 4, 9, 9),
            solution.sortedSquares(intArrayOf(-3, -3, 0, 0, 2))
        )
    }

    @Test
    fun handlesAllPositiveValues() {
        assertArrayEquals(
            intArrayOf(1, 4, 9),
            solution.sortedSquares(intArrayOf(1, 2, 3))
        )
    }
}
