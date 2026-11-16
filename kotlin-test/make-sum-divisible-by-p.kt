package makesumdivisiblebyp

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class MakeSumDivisibleByPTest {
    @Test
    fun testExample1() {
        assertEquals(1, Solution().minSubarray(intArrayOf(3, 1, 4, 2), 6))
    }

    @Test
    fun testExample2() {
        assertEquals(2, Solution().minSubarray(intArrayOf(6, 3, 5, 2), 9))
    }

    @Test
    fun testAlreadyDivisible() {
        assertEquals(0, Solution().minSubarray(intArrayOf(1, 2, 3), 3))
    }

    @Test
    fun testImpossible() {
        assertEquals(-1, Solution().minSubarray(intArrayOf(1, 2, 3), 7))
    }

    @Test
    fun testSingleElement() {
        assertEquals(-1, Solution().minSubarray(intArrayOf(3), 5))
    }

    @Test
    fun testNeedWholeArray() {
        assertEquals(-1, Solution().minSubarray(intArrayOf(1, 1), 3))
    }
}
