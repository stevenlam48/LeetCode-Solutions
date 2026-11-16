package subarraysdistinctelementsumofsquaresii

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class SubarraysDistinctElementSumOfSquaresIiTest {
    @Test
    fun testExample1() {
        assertEquals(15, Solution().sumCounts(intArrayOf(1, 2, 1)))
    }

    @Test
    fun testExample2() {
        assertEquals(1, Solution().sumCounts(intArrayOf(1)))
    }

    @Test
    fun testAllSame() {
        assertEquals(6, Solution().sumCounts(intArrayOf(1, 1, 1)))
    }

    @Test
    fun testRepeatingPattern() {
        assertEquals(293, Solution().sumCounts(intArrayOf(1, 2, 3, 1, 2, 3, 1, 2, 3)))
    }

    @Test
    fun testMediumArray() {
        val nums = IntArray(300) { (it * 7 + 3) % 5 + 1 }
        assertEquals(1107830, Solution().sumCounts(nums))
    }

    @Test
    fun testLargerArray() {
        val nums = IntArray(1000) { (it * 13 + 5) % 7 + 1 }
        assertEquals(24321885, Solution().sumCounts(nums))
    }
}
