package arraypartitioni

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class ArrayPartitionITest {
    private val solution = Solution()

    @Test
    fun testExample() {
        assertEquals(4, solution.arrayPairSum(intArrayOf(1, 4, 3, 2)))
    }

    @Test
    fun testDuplicates() {
        assertEquals(9, solution.arrayPairSum(intArrayOf(6, 2, 6, 5, 1, 2)))
    }

    @Test
    fun testPair() {
        assertEquals(1, solution.arrayPairSum(intArrayOf(1, 1)))
    }

    @Test
    fun testNegatives() {
        assertEquals(-2, solution.arrayPairSum(intArrayOf(-1, -2)))
    }
}
