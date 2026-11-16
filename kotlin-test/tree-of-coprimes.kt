package treeofcoprimes

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class TreeOfCoprimesTest {
    @Test
    fun standardExamples() {
        assertArrayEquals(intArrayOf(-1, 0, 0, 1), Solution().getCoprimes(
            intArrayOf(2, 3, 3, 2), arrayOf(intArrayOf(0, 1), intArrayOf(1, 2), intArrayOf(1, 3))))
        assertArrayEquals(intArrayOf(-1, 0, -1, 0, 3), Solution().getCoprimes(
            intArrayOf(5, 6, 10, 2, 3), arrayOf(intArrayOf(0, 1), intArrayOf(0, 2), intArrayOf(1, 3), intArrayOf(3, 4))))
    }

    @Test
    fun nearestCoprimeAncestorWins() {
        assertArrayEquals(intArrayOf(-1, 0, 1), Solution().getCoprimes(
            intArrayOf(2, 3, 5), arrayOf(intArrayOf(0, 1), intArrayOf(1, 2))))
        assertArrayEquals(intArrayOf(-1, 0, 0), Solution().getCoprimes(
            intArrayOf(2, 3, 7), arrayOf(intArrayOf(0, 1), intArrayOf(0, 2))))
    }

    @Test
    fun singleNodeAndNoCoprimeAncestor() {
        assertArrayEquals(intArrayOf(-1), Solution().getCoprimes(intArrayOf(1), arrayOf()))
        assertArrayEquals(intArrayOf(-1, -1), Solution().getCoprimes(intArrayOf(4, 6), arrayOf(intArrayOf(0, 1))))
    }
}
