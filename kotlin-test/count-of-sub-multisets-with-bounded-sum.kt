package countofsubmultisetswithboundedsum

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class CountOfSubMultisetsWithBoundedSumTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertEquals(1, solution.countSubMultisets(intArrayOf(1, 2, 2, 3), 6, 6))
    }

    @Test
    fun testExample2() {
        assertEquals(7, solution.countSubMultisets(intArrayOf(2, 1, 4, 2, 7), 1, 5))
    }

    @Test
    fun testDuplicates() {
        assertEquals(4, solution.countSubMultisets(intArrayOf(1, 2, 1, 2), 1, 3))
    }

    @Test
    fun testZeros() {
        assertEquals(6, solution.countSubMultisets(intArrayOf(0, 0, 1), 0, 1))
    }

    @Test
    fun testEmpty() {
        assertEquals(0, solution.countSubMultisets(intArrayOf(), 1, 5))
    }
}
