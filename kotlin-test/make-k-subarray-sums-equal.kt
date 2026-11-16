package makeksubarraysumsequal

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class MakeKSubarraySumsEqualTest {
    @Test
    fun testExample1() {
        assertEquals(9L, Solution().makeSubKSumEqual(intArrayOf(1, 2, 3, 4, 5, 6), 3))
    }

    @Test
    fun testExample2() {
        assertEquals(0L, Solution().makeSubKSumEqual(intArrayOf(1, 2, 3, 4, 5, 6), 6))
    }

    @Test
    fun testSingleElement() {
        assertEquals(0L, Solution().makeSubKSumEqual(intArrayOf(7), 1))
    }

    @Test
    fun testAlreadyEqual() {
        assertEquals(0L, Solution().makeSubKSumEqual(intArrayOf(5, 5, 5, 5), 2))
    }

    @Test
    fun testNegativeValues() {
        assertEquals(4L, Solution().makeSubKSumEqual(intArrayOf(-1, 0, 1, 2), 2))
    }
}
