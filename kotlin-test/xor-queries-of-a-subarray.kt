package xorqueriesofasubarray

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class XorQueriesOfASubarrayTest {
    @Test
    fun firstExample() {
        assertArrayEquals(
            intArrayOf(2, 7, 14, 8),
            Solution().xorQueries(
                intArrayOf(1, 3, 4, 8),
                arrayOf(intArrayOf(0, 1), intArrayOf(1, 2), intArrayOf(0, 3), intArrayOf(3, 3))
            )
        )
    }

    @Test
    fun secondExample() {
        assertArrayEquals(
            intArrayOf(6, 10),
            Solution().xorQueries(intArrayOf(2, 4, 6, 8), arrayOf(intArrayOf(0, 1), intArrayOf(1, 3)))
        )
    }

    @Test
    fun singleElement() {
        assertArrayEquals(
            intArrayOf(5, 5),
            Solution().xorQueries(intArrayOf(5), arrayOf(intArrayOf(0, 0), intArrayOf(0, 0)))
        )
    }

    @Test
    fun noQueries() {
        assertArrayEquals(intArrayOf(), Solution().xorQueries(intArrayOf(1, 2), emptyArray()))
    }
}
