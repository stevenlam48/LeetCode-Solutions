package smallestindexwithdigitsumequaltoindex

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class SmallestIndexWithDigitSumEqualToIndexTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertEquals(2, solution.smallestIndex(intArrayOf(1, 3, 2)))
    }

    @Test
    fun testExample2() {
        assertEquals(1, solution.smallestIndex(intArrayOf(1, 10, 11)))
    }

    @Test
    fun testExample3() {
        assertEquals(-1, solution.smallestIndex(intArrayOf(1, 2, 3)))
    }

    @Test
    fun testZeroAtZero() {
        assertEquals(0, solution.smallestIndex(intArrayOf(0, 5, 6)))
    }

    @Test
    fun testMultiDigitSum() {
        assertEquals(3, solution.smallestIndex(intArrayOf(9, 9, 9, 12)))
    }
}
