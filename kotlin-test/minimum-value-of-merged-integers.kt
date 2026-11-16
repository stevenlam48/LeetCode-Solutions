package minimumvalueofmergedintegers

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class MinimumValueOfMergedIntegersTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertEquals(12, solution.minMergedInteger(intArrayOf(1, 2, 3, 4)))
    }

    @Test
    fun testExample2() {
        assertEquals(102, solution.minMergedInteger(intArrayOf(10, 2)))
    }

    @Test
    fun testMultiDigit() {
        assertEquals(330, solution.minMergedInteger(intArrayOf(3, 30)))
    }

    @Test
    fun testZero() {
        assertEquals(1, solution.minMergedInteger(intArrayOf(0, 1)))
    }

    @Test
    fun testThreePairs() {
        assertEquals(56, solution.minMergedInteger(intArrayOf(5, 6, 7, 8, 9, 1)))
    }
}
