package minimumdeletionstomakealternatingsubstring

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class MinimumDeletionsToMakeAlternatingSubstringTest {
    @Test
    fun example1() {
        assertArrayEquals(intArrayOf(1), Solution().minDeletions("ABBA", arrayOf(intArrayOf(2, 0, 3))))
    }

    @Test
    fun allSame() {
        assertArrayEquals(intArrayOf(3), Solution().minDeletions("AAAA", arrayOf(intArrayOf(2, 0, 3))))
    }

    @Test
    fun alternating() {
        assertArrayEquals(intArrayOf(0), Solution().minDeletions("ABAB", arrayOf(intArrayOf(2, 0, 3))))
    }

    @Test
    fun flipThenQuery() {
        val queries = arrayOf(intArrayOf(2, 0, 3), intArrayOf(1, 1), intArrayOf(2, 0, 3))
        assertArrayEquals(intArrayOf(2, 2), Solution().minDeletions("AABB", queries))
    }

    @Test
    fun lengthTwo() {
        assertArrayEquals(intArrayOf(0), Solution().minDeletions("AB", arrayOf(intArrayOf(2, 0, 1))))
    }

    @Test
    fun lengthTwoSame() {
        assertArrayEquals(intArrayOf(1), Solution().minDeletions("AA", arrayOf(intArrayOf(2, 0, 1))))
    }
}
