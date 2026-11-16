package minimumnumbersoffunctioncallstomaketargetarray

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class MinimumNumbersOfFunctionCallsToMakeTargetArrayTest {

    @Test
    fun testExample1() {
        assertEquals(5, Solution().minOperations(intArrayOf(1, 5)))
    }

    @Test
    fun testExample2() {
        assertEquals(4, Solution().minOperations(intArrayOf(1, 3)))
    }

    @Test
    fun testExample3() {
        assertEquals(0, Solution().minOperations(intArrayOf(0, 0)))
    }

    @Test
    fun testSingleZero() {
        assertEquals(0, Solution().minOperations(intArrayOf(0)))
    }

    @Test
    fun testSingleOne() {
        assertEquals(1, Solution().minOperations(intArrayOf(1)))
    }

    @Test
    fun testPowersOfTwo() {
        assertEquals(4, Solution().minOperations(intArrayOf(2, 4)))
    }

    @Test
    fun testAllOnes() {
        assertEquals(3, Solution().minOperations(intArrayOf(1, 1, 1)))
    }
}
