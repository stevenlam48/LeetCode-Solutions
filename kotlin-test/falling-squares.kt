package fallingsquares

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class FallingSquaresTest {
    private val solution = Solution()

    @Test
    fun overlappingSquaresExample() {
        val positions = arrayOf(
            intArrayOf(1, 2),
            intArrayOf(2, 3),
            intArrayOf(6, 1)
        )
        assertArrayEquals(intArrayOf(2, 5, 5), solution.fallingSquares(positions))
    }

    @Test
    fun separatedSquaresExample() {
        val positions = arrayOf(intArrayOf(100, 100), intArrayOf(200, 100))
        assertArrayEquals(intArrayOf(100, 100), solution.fallingSquares(positions))
    }

    @Test
    fun adjacentSquaresSupportAThirdSquare() {
        val positions = arrayOf(
            intArrayOf(1, 2),
            intArrayOf(3, 2),
            intArrayOf(2, 2)
        )
        assertArrayEquals(intArrayOf(2, 2, 4), solution.fallingSquares(positions))
    }

    @Test
    fun squareAtSameLeftEdgeStacks() {
        val positions = arrayOf(intArrayOf(2, 3), intArrayOf(2, 2))
        assertArrayEquals(intArrayOf(3, 5), solution.fallingSquares(positions))
    }

    @Test
    fun emptyInput() {
        assertArrayEquals(intArrayOf(), solution.fallingSquares(emptyArray()))
    }
}
