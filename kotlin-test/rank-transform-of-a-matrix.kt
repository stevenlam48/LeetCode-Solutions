package ranktransformofamatrix
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class RankTransformOfAMatrixTest {
    @Test
    fun simpleIncreasingMatrix() {
        val matrix = arrayOf(intArrayOf(1, 2), intArrayOf(3, 4))
        val result = Solution().matrixRankTransform(matrix)
        assertArrayEquals(intArrayOf(1, 2), result[0])
        assertArrayEquals(intArrayOf(2, 3), result[1])
        assertSame(matrix, result)
    }

    @Test
    fun leetCodeExample() {
        val result = Solution().matrixRankTransform(arrayOf(
            intArrayOf(20, -21, 14),
            intArrayOf(-19, 4, 19),
            intArrayOf(22, -47, 24),
            intArrayOf(-19, 4, 19)
        ))
        val expected = arrayOf(
            intArrayOf(4, 2, 3),
            intArrayOf(1, 3, 4),
            intArrayOf(5, 1, 6),
            intArrayOf(1, 3, 4)
        )
        for (i in expected.indices) {
            assertArrayEquals(expected[i], result[i])
        }
    }

    @Test
    fun allEqualValues() {
        val result = Solution().matrixRankTransform(Array(3) { IntArray(4) { 7 } })
        assertTrue(result.all { row -> row.all { it == 1 } })
    }

    @Test
    fun duplicatesSpanningRowsAndColumns() {
        val result = Solution().matrixRankTransform(arrayOf(
            intArrayOf(5, 1, 5),
            intArrayOf(1, 5, 2),
            intArrayOf(5, 3, 5)
        ))
        val expected = arrayOf(
            intArrayOf(3, 1, 3),
            intArrayOf(1, 3, 2),
            intArrayOf(3, 2, 3)
        )
        for (i in expected.indices) {
            assertArrayEquals(expected[i], result[i])
        }
    }
}
