package minimumnumberofflipstoconvertbinarymatrixtozeromatrix

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumNumberOfFlipsToConvertBinaryMatrixToZeroMatrixTest {
    private val solution = Solution()

    @Test
    fun alreadyZero() {
        assertEquals(0, solution.minFlips(arrayOf(intArrayOf(0))))
    }

    @Test
    fun singleFlip() {
        assertEquals(1, solution.minFlips(arrayOf(intArrayOf(1))))
    }

    @Test
    fun threeFlips() {
        val mat = arrayOf(
            intArrayOf(0, 0),
            intArrayOf(0, 1)
        )
        assertEquals(3, solution.minFlips(mat))
    }

    @Test
    fun impossibleMatrix() {
        val mat = arrayOf(
            intArrayOf(1, 0, 0),
            intArrayOf(1, 0, 0)
        )
        assertEquals(-1, solution.minFlips(mat))
    }

    @Test
    fun sixFlips() {
        val mat = arrayOf(
            intArrayOf(1, 1, 1),
            intArrayOf(1, 0, 1),
            intArrayOf(0, 0, 0)
        )
        assertEquals(6, solution.minFlips(mat))
    }
}
