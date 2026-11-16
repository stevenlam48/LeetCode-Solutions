package maximumxoroftwonumbersinanarray

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumXorOfTwoNumbersInAnArrayTest {
    private val solution = Solution()

    @Test
    fun exampleOne() {
        assertEquals(28, solution.findMaximumXOR(intArrayOf(3, 10, 5, 25, 2, 8)))
    }

    @Test
    fun exampleTwo() {
        val nums = intArrayOf(14, 70, 53, 83, 49, 91, 36, 80, 92, 51, 66, 70)
        assertEquals(127, solution.findMaximumXOR(nums))
    }

    @Test
    fun singleZero() {
        assertEquals(0, solution.findMaximumXOR(intArrayOf(0)))
    }

    @Test
    fun twoValues() {
        assertEquals(3, solution.findMaximumXOR(intArrayOf(1, 2)))
    }
}
