package subarraysumequalsk

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class SubarraySumEqualsKTest {
    @Test
    fun testExample1() {
        assertEquals(2, Solution().subarraySum(intArrayOf(1, 1, 1), 2))
    }

    @Test
    fun testExample2() {
        assertEquals(2, Solution().subarraySum(intArrayOf(1, 2, 3), 3))
    }

    @Test
    fun testNegatives() {
        assertEquals(3, Solution().subarraySum(intArrayOf(1, -1, 0), 0))
    }

    @Test
    fun testSingleElement() {
        assertEquals(1, Solution().subarraySum(intArrayOf(5), 5))
        assertEquals(0, Solution().subarraySum(intArrayOf(5), 3))
    }

    @Test
    fun testEmpty() {
        assertEquals(0, Solution().subarraySum(intArrayOf(), 0))
    }
}
