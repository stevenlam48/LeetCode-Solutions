package thekstrongestvaluesinanarray

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class TheKStrongestValuesInAnArrayTest {

    @Test
    fun testExample1() {
        val result = Solution().getStrongest(intArrayOf(1, 2, 3, 4, 5), 2)
        assertArrayEquals(intArrayOf(5, 1), result.sortedArrayDescending())
    }

    @Test
    fun testExample2() {
        val result = Solution().getStrongest(intArrayOf(1, 1, 3, 5, 5), 2)
        assertArrayEquals(intArrayOf(5, 5), result.sortedArrayDescending())
    }

    @Test
    fun testExample3() {
        val result = Solution().getStrongest(intArrayOf(6, 7, 11, 7, 6, 8), 5)
        assertArrayEquals(intArrayOf(11, 8, 7, 6, 6), result.sortedArrayDescending())
    }

    @Test
    fun testSingleElement() {
        assertArrayEquals(intArrayOf(7), Solution().getStrongest(intArrayOf(7), 1))
    }

    @Test
    fun testAllElements() {
        val result = Solution().getStrongest(intArrayOf(-3, 0, 3), 3)
        assertArrayEquals(intArrayOf(3, 0, -3), result.sortedArrayDescending())
    }

    @Test
    fun testNegatives() {
        val result = Solution().getStrongest(intArrayOf(-7, -3, 2, 5, 9), 3)
        assertArrayEquals(intArrayOf(9, -3, -7), result.sortedArrayDescending())
    }
}
