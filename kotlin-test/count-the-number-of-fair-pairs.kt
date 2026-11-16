package countthenumberoffairpairs

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class CountTheNumberOfFairPairsTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertEquals(6L, solution.countFairPairs(intArrayOf(0, 1, 7, 4, 4, 5), 3, 6))
    }

    @Test
    fun testExample2() {
        assertEquals(1L, solution.countFairPairs(intArrayOf(1, 7, 9, 2, 5), 11, 11))
    }

    @Test
    fun testAllZeros() {
        assertEquals(3L, solution.countFairPairs(intArrayOf(0, 0, 0), 0, 0))
    }

    @Test
    fun testSingleElement() {
        assertEquals(0L, solution.countFairPairs(intArrayOf(5), 0, 10))
    }

    @Test
    fun testNegatives() {
        assertEquals(1L, solution.countFairPairs(intArrayOf(-5, 5), 0, 0))
    }
}
