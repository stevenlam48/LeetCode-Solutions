package countpairsintwoarrays

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class CountPairsInTwoArraysTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertEquals(1L, solution.countPairs(intArrayOf(2, 1, 2, 1), intArrayOf(1, 2, 1, 2)))
    }

    @Test
    fun testExample2() {
        assertEquals(0L, solution.countPairs(intArrayOf(1, 2, 3, 4), intArrayOf(1, 2, 3, 4)))
    }

    @Test
    fun testAllGreater() {
        assertEquals(1L, solution.countPairs(intArrayOf(5, 5), intArrayOf(1, 1)))
    }

    @Test
    fun testSingleElement() {
        assertEquals(0L, solution.countPairs(intArrayOf(1), intArrayOf(2)))
    }

    @Test
    fun testEmpty() {
        assertEquals(0L, solution.countPairs(intArrayOf(), intArrayOf()))
    }
}
