package largestnumberatleasttwiceofothers

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class LargestNumberAtLeastTwiceOfOthersTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertEquals(1, solution.dominantIndex(intArrayOf(3, 6, 1, 0)))
    }

    @Test
    fun testExample2() {
        assertEquals(-1, solution.dominantIndex(intArrayOf(1, 2, 3, 4)))
    }

    @Test
    fun testSingleElement() {
        assertEquals(0, solution.dominantIndex(intArrayOf(1)))
    }

    @Test
    fun testZeros() {
        assertEquals(3, solution.dominantIndex(intArrayOf(0, 0, 0, 1)))
    }

    @Test
    fun testExactlyTwice() {
        assertEquals(0, solution.dominantIndex(intArrayOf(2, 1)))
    }
}
