package minimumoperationstoexceedthresholdvaluei

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class MinimumOperationsToExceedThresholdValueITest {

    @Test
    fun testExample1() {
        assertEquals(3, Solution().minOperations(intArrayOf(2, 11, 10, 1, 3), 10))
    }

    @Test
    fun testExample2() {
        assertEquals(0, Solution().minOperations(intArrayOf(1, 1, 2, 4, 9), 1))
    }

    @Test
    fun testExample3() {
        assertEquals(4, Solution().minOperations(intArrayOf(1, 1, 2, 4, 9), 9))
    }

    @Test
    fun testAllBelow() {
        assertEquals(3, Solution().minOperations(intArrayOf(1, 2, 3), 100))
    }

    @Test
    fun testSingleElement() {
        assertEquals(0, Solution().minOperations(intArrayOf(5), 5))
        assertEquals(1, Solution().minOperations(intArrayOf(4), 5))
    }
}
