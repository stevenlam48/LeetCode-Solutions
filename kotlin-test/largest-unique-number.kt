package largestuniquenumber

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class LargestUniqueNumberTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertEquals(8, solution.largestUniqueNumber(intArrayOf(5, 7, 3, 9, 4, 9, 8, 3, 1)))
    }

    @Test
    fun testExample2() {
        assertEquals(-1, solution.largestUniqueNumber(intArrayOf(9, 9, 8, 8)))
    }

    @Test
    fun testSingleElement() {
        assertEquals(1, solution.largestUniqueNumber(intArrayOf(1)))
    }

    @Test
    fun testDuplicateOfLargest() {
        assertEquals(1, solution.largestUniqueNumber(intArrayOf(1, 2, 2)))
    }

    @Test
    fun testAllUnique() {
        assertEquals(3, solution.largestUniqueNumber(intArrayOf(1, 2, 3)))
    }
}
