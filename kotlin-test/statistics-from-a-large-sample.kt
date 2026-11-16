package statisticsfromalargesample

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class StatisticsFromALargeSampleTest {
    private val solution = Solution()

    private fun countOf(vararg pairs: Pair<Int, Int>): IntArray {
        val count = IntArray(256)
        for ((idx, v) in pairs) {
            count[idx] = v
        }
        return count
    }

    @Test
    fun testExample1() {
        val result = solution.sampleStats(countOf(1 to 1, 2 to 3, 3 to 4))
        assertArrayEquals(
            doubleArrayOf(1.0, 3.0, 2.375, 2.5, 3.0),
            result,
            1e-5
        )
    }

    @Test
    fun testExample2() {
        val result = solution.sampleStats(countOf(1 to 4, 2 to 3, 3 to 2, 4 to 2))
        assertArrayEquals(
            doubleArrayOf(1.0, 4.0, 2.1818181818181817, 2.0, 1.0),
            result,
            1e-5
        )
    }

    @Test
    fun testSingleValue() {
        val result = solution.sampleStats(countOf(7 to 5))
        assertArrayEquals(doubleArrayOf(7.0, 7.0, 7.0, 7.0, 7.0), result, 1e-5)
    }

    @Test
    fun testTwoValues() {
        val result = solution.sampleStats(countOf(0 to 1, 1 to 1))
        assertArrayEquals(doubleArrayOf(0.0, 1.0, 0.5, 0.5, 0.0), result, 1e-5)
    }
}
