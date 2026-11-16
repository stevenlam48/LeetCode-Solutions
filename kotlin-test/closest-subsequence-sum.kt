package closestsubsequencesum

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ClosestSubsequenceSumTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertEquals(1, solution.minAbsDifference(intArrayOf(5, -7, 0, 5), 6))
    }

    @Test
    fun testExample2() {
        assertEquals(0, solution.minAbsDifference(intArrayOf(7, -9, 15, -2), 5))
    }

    @Test
    fun testExample3() {
        assertEquals(7, solution.minAbsDifference(intArrayOf(1, 2, 3), -7))
    }

    @Test
    fun testExactSubsetSum() {
        assertEquals(0, solution.minAbsDifference(intArrayOf(1, 2, 3), 4))
    }

    @Test
    fun testSingleElement() {
        assertEquals(3, solution.minAbsDifference(intArrayOf(4), 7))
        assertEquals(0, solution.minAbsDifference(intArrayOf(4), 4))
    }
}
