package ranktransformofanarray
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class RankTransformOfAnArrayTest {
    @Test
    fun distinctValues() {
        assertArrayEquals(intArrayOf(4, 1, 2, 3), Solution().arrayRankTransform(intArrayOf(40, 10, 20, 30)))
    }

    @Test
    fun duplicatesAndNegatives() {
        assertArrayEquals(
            intArrayOf(5, 3, 4, 2, 8, 6, 7, 1, 3),
            Solution().arrayRankTransform(intArrayOf(37, 12, 28, 9, 100, 56, 80, 5, 12))
        )
        assertArrayEquals(intArrayOf(2, 1, 2, 3), Solution().arrayRankTransform(intArrayOf(0, -5, 0, 9)))
    }

    @Test
    fun allValuesEqual() {
        assertArrayEquals(intArrayOf(1, 1, 1), Solution().arrayRankTransform(intArrayOf(100, 100, 100)))
    }

    @Test
    fun emptyArray() {
        assertArrayEquals(intArrayOf(), Solution().arrayRankTransform(intArrayOf()))
    }
}
