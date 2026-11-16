package subarraysumsdivisiblebyk

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class SubarraySumsDivisibleByKTest {
    @Test
    fun testExample1() {
        assertEquals(7, Solution().subarraysDivByK(intArrayOf(4, 5, 0, -2, -3, 1), 5))
    }

    @Test
    fun testExample2() {
        assertEquals(0, Solution().subarraysDivByK(intArrayOf(5), 9))
    }

    @Test
    fun testAllDivisible() {
        assertEquals(6, Solution().subarraysDivByK(intArrayOf(2, 4, 6), 2))
    }

    @Test
    fun testNegatives() {
        assertEquals(3, Solution().subarraysDivByK(intArrayOf(-1, 1), 1))
    }

    @Test
    fun testSingleZero() {
        assertEquals(1, Solution().subarraysDivByK(intArrayOf(0), 7))
    }
}
