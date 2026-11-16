package cyclelengthqueriesinatree

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class CycleLengthQueriesInATreeTest {
    @Test
    fun example1() {
        val queries = arrayOf(intArrayOf(5, 3), intArrayOf(4, 7), intArrayOf(2, 3))
        assertArrayEquals(intArrayOf(4, 5, 3), Solution().cycleLengthQueries(3, queries))
    }

    @Test
    fun example2() {
        val queries = arrayOf(intArrayOf(1, 2))
        assertArrayEquals(intArrayOf(2), Solution().cycleLengthQueries(2, queries))
    }

    @Test
    fun rootToLeaf() {
        val queries = arrayOf(intArrayOf(1, 16))
        assertArrayEquals(intArrayOf(5), Solution().cycleLengthQueries(4, queries))
    }

    @Test
    fun sameNode() {
        val queries = arrayOf(intArrayOf(7, 7))
        assertArrayEquals(intArrayOf(1), Solution().cycleLengthQueries(3, queries))
    }

    @Test
    fun siblings() {
        val queries = arrayOf(intArrayOf(4, 5))
        assertArrayEquals(intArrayOf(3), Solution().cycleLengthQueries(3, queries))
    }
}
