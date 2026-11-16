package recovertheoriginalarray

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class RecoverTheOriginalArrayTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertArrayEquals(intArrayOf(3, 7, 11), solution.recoverArray(intArrayOf(2, 10, 6, 4, 8, 12)))
    }

    @Test
    fun testExample2() {
        assertArrayEquals(intArrayOf(2, 2), solution.recoverArray(intArrayOf(1, 1, 3, 3)))
    }

    @Test
    fun testExample3() {
        assertArrayEquals(intArrayOf(220), solution.recoverArray(intArrayOf(5, 435)))
    }

    @Test
    fun testSingleElementPair() {
        assertArrayEquals(intArrayOf(4), solution.recoverArray(intArrayOf(1, 7)))
    }

    @Test
    fun testTwoPairs() {
        assertArrayEquals(intArrayOf(2, 10), solution.recoverArray(intArrayOf(1, 3, 9, 11)))
    }

    @Test
    fun testDuplicateValues() {
        assertArrayEquals(intArrayOf(5, 5, 5), solution.recoverArray(intArrayOf(1, 1, 1, 9, 9, 9)))
    }
}
