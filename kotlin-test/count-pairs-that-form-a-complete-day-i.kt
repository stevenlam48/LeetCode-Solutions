package countpairsthatformacompletedayi

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class CountPairsThatFormACompleteDayITest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertEquals(2, solution.countCompleteDayPairs(intArrayOf(12, 12, 30, 24, 24)))
    }

    @Test
    fun testExample2() {
        assertEquals(3, solution.countCompleteDayPairs(intArrayOf(72, 48, 24, 3)))
    }

    @Test
    fun testSingleElement() {
        assertEquals(0, solution.countCompleteDayPairs(intArrayOf(12)))
    }

    @Test
    fun testEmpty() {
        assertEquals(0, solution.countCompleteDayPairs(intArrayOf()))
    }

    @Test
    fun testZeros() {
        assertEquals(1, solution.countCompleteDayPairs(intArrayOf(0, 0)))
    }
}
