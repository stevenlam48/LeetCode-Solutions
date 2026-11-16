package subarraysdistinctelementsumofsquaresi

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class SubarraysDistinctElementSumOfSquaresITest {
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
    fun testAllDistinct() {
        assertEquals(50, Solution().sumCounts(intArrayOf(1, 2, 3, 4)))
    }

    @Test
    fun testMixed() {
        assertEquals(38, Solution().sumCounts(intArrayOf(1, 2, 1, 3)))
    }
}
