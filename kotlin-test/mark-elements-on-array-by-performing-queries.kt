package markelementsonarraybyperformingqueries

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class MarkElementsOnArrayByPerformingQueriesTest {
    @Test
    fun testExample1() {
        assertArrayEquals(
            longArrayOf(8L, 3L, 0L),
            Solution().unmarkedSumArray(
                intArrayOf(1, 2, 2, 1, 2, 3, 1),
                arrayOf(intArrayOf(1, 2), intArrayOf(3, 3), intArrayOf(4, 2))
            )
        )
    }

    @Test
    fun testExample2() {
        assertArrayEquals(
            longArrayOf(7L, 0L),
            Solution().unmarkedSumArray(
                intArrayOf(1, 4, 2, 3),
                arrayOf(intArrayOf(0, 1), intArrayOf(1, 2))
            )
        )
    }

    @Test
    fun testSingleQuery() {
        assertArrayEquals(
            longArrayOf(4L),
            Solution().unmarkedSumArray(intArrayOf(5, 4, 3), arrayOf(intArrayOf(0, 1)))
        )
    }

    @Test
    fun testMarkAll() {
        assertArrayEquals(
            longArrayOf(0L),
            Solution().unmarkedSumArray(intArrayOf(5, 4, 3), arrayOf(intArrayOf(2, 2)))
        )
    }

    @Test
    fun testRepeatedIndex() {
        assertArrayEquals(
            longArrayOf(5L, 3L),
            Solution().unmarkedSumArray(
                intArrayOf(2, 3, 4),
                arrayOf(intArrayOf(2, 0), intArrayOf(2, 1))
            )
        )
    }
}
