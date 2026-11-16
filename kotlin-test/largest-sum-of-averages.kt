package largestsumofaverages

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class LargestSumOfAveragesTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertEquals(20.0, solution.largestSumOfAverages(intArrayOf(9, 1, 2, 3, 9), 3), 1e-9)
    }

    @Test
    fun testExample2() {
        assertEquals(20.5, solution.largestSumOfAverages(intArrayOf(1, 2, 3, 4, 5, 6, 7), 4), 1e-9)
    }

    @Test
    fun testSingleGroup() {
        assertEquals(2.0, solution.largestSumOfAverages(intArrayOf(1, 2, 3), 1), 1e-9)
    }

    @Test
    fun testEachElementSeparate() {
        assertEquals(6.0, solution.largestSumOfAverages(intArrayOf(1, 2, 3), 3), 1e-9)
    }

    @Test
    fun testSingleElement() {
        assertEquals(5.0, solution.largestSumOfAverages(intArrayOf(5), 1), 1e-9)
    }
}
