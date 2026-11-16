package countpairsthatformacompletedayii

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class CountPairsThatFormACompleteDayIITest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertEquals(2L, solution.countCompleteDayPairs(intArrayOf(12, 12, 30, 24, 24)))
    }

    @Test
    fun testExample2() {
        assertEquals(3L, solution.countCompleteDayPairs(intArrayOf(72, 48, 24, 3)))
    }

    @Test
    fun testSingleElement() {
        assertEquals(0L, solution.countCompleteDayPairs(intArrayOf(12)))
    }

    @Test
    fun testEmpty() {
        assertEquals(0L, solution.countCompleteDayPairs(intArrayOf()))
    }

    @Test
    fun testZeros() {
        assertEquals(1L, solution.countCompleteDayPairs(intArrayOf(0, 0)))
    }
}
