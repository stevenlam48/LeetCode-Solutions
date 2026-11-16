package minimumoperationstoexceedthresholdvalueii

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class MinimumOperationsToExceedThresholdValueIITest {

    @Test
    fun testExample1() {
        assertEquals(2, Solution().minOperations(intArrayOf(2, 11, 10, 1, 3), 10))
    }

    @Test
    fun testExample2() {
        assertEquals(5, Solution().minOperations(intArrayOf(1, 1, 2, 4, 9, 9), 20))
    }

    @Test
    fun testAlreadyAbove() {
        assertEquals(0, Solution().minOperations(intArrayOf(5, 6, 7), 5))
    }

    @Test
    fun testTwoElements() {
        assertEquals(1, Solution().minOperations(intArrayOf(1, 2), 4))
    }

    @Test
    fun testLargeValues() {
        assertEquals(1, Solution().minOperations(intArrayOf(1000000000, 1000000000), 2000000000))
    }
}
