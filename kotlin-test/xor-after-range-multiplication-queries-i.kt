package xorafterrangemultiplicationqueriesi

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class XorAfterRangeMultiplicationQueriesITest {
    @Test
    fun combinesQueries() {
        assertEquals(
            16,
            Solution().xorAfterQueries(
                intArrayOf(1, 2, 3, 4),
                arrayOf(intArrayOf(0, 3, 1, 2), intArrayOf(1, 3, 2, 3))
            )
        )
    }

    @Test
    fun largeStrideUpdatesDirectly() {
        assertEquals(
            39,
            Solution().xorAfterQueries(intArrayOf(1, 2, 3, 4, 5, 6), arrayOf(intArrayOf(1, 5, 4, 7)))
        )
    }

    @Test
    fun differenceArraysCompose() {
        assertEquals(
            124,
            Solution().xorAfterQueries(
                intArrayOf(2, 3, 5, 7, 11),
                arrayOf(intArrayOf(0, 4, 2, 6), intArrayOf(1, 3, 2, 5))
            )
        )
    }

    @Test
    fun noQueries() {
        assertEquals(7, Solution().xorAfterQueries(intArrayOf(1, 2, 4), emptyArray()))
    }
}
