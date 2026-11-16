package countnicepairsinanarray

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class CountNicePairsInAnArrayTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertEquals(2, solution.countNicePairs(intArrayOf(42, 11, 1, 97)))
    }

    @Test
    fun testExample2() {
        assertEquals(4, solution.countNicePairs(intArrayOf(13, 10, 35, 24, 76)))
    }

    @Test
    fun testSingleElement() {
        assertEquals(0, solution.countNicePairs(intArrayOf(1)))
    }

    @Test
    fun testAllSameDifference() {
        assertEquals(6, solution.countNicePairs(intArrayOf(1, 1, 1, 1)))
    }
}
