package findrightinterval

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class FindRightIntervalTest {
    @Test
    fun testExample1() {
        val intervals = arrayOf(Interval(1, 2))
        assertArrayEquals(intArrayOf(-1), Solution().findRightInterval(intervals))
    }

    @Test
    fun testExample2() {
        val intervals = arrayOf(Interval(3, 4), Interval(2, 3), Interval(1, 2))
        assertArrayEquals(intArrayOf(-1, 0, 1), Solution().findRightInterval(intervals))
    }

    @Test
    fun testExample3() {
        val intervals = arrayOf(Interval(1, 4), Interval(2, 3), Interval(3, 4))
        assertArrayEquals(intArrayOf(-1, 2, -1), Solution().findRightInterval(intervals))
    }

    @Test
    fun testSharedStarts() {
        val intervals = arrayOf(Interval(1, 1), Interval(1, 2))
        // start 1 maps to the last index that has it (index 1).
        assertArrayEquals(intArrayOf(1, -1), Solution().findRightInterval(intervals))
    }
}
