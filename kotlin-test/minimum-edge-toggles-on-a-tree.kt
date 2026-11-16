package minimumedgetogglesonatree

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class MinimumEdgeTogglesOnATreeTest {
    @Test
    fun exampleSingleEdge() {
        val edges = arrayOf(intArrayOf(0, 1))
        assertArrayEquals(intArrayOf(0), Solution().minimumFlips(2, edges, "00", "11"))
    }

    @Test
    fun exampleAlternatingPath() {
        val edges = arrayOf(intArrayOf(0, 1), intArrayOf(1, 2), intArrayOf(2, 3))
        assertArrayEquals(intArrayOf(0, 2), Solution().minimumFlips(4, edges, "0000", "1111"))
    }

    @Test
    fun noDifferenceNeedsNoFlips() {
        val edges = arrayOf(intArrayOf(0, 1))
        assertArrayEquals(intArrayOf(), Solution().minimumFlips(2, edges, "01", "01"))
    }

    @Test
    fun singleNodeAlreadyMatches() {
        assertArrayEquals(intArrayOf(), Solution().minimumFlips(1, arrayOf(), "1", "1"))
    }

    @Test
    fun oddDifferenceIsImpossible() {
        assertArrayEquals(intArrayOf(-1), Solution().minimumFlips(1, arrayOf(), "0", "1"))
    }
}
