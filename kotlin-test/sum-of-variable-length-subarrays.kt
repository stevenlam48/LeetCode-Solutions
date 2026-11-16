package sumofvariablelengthsubarrays

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class SumOfVariableLengthSubarraysTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertEquals(11, solution.subarraySum(intArrayOf(2, 3, 1)))
    }

    @Test
    fun testExample2() {
        assertEquals(13, solution.subarraySum(intArrayOf(3, 1, 1, 2)))
    }

    @Test
    fun testSingleElement() {
        assertEquals(5, solution.subarraySum(intArrayOf(5)))
    }

    @Test
    fun testAllOnes() {
        assertEquals(5, solution.subarraySum(intArrayOf(1, 1, 1)))
    }

    @Test
    fun testLargeValues() {
        assertEquals(24, solution.subarraySum(intArrayOf(4, 4, 4)))
    }
}
