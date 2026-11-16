package sumofdistancesintree

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class SumOfDistancesInTreeTest {
    @Test
    fun exampleOne() {
        val edges = arrayOf(
            intArrayOf(0, 1),
            intArrayOf(0, 2),
            intArrayOf(2, 3),
            intArrayOf(2, 4),
            intArrayOf(2, 5)
        )
        assertArrayEquals(intArrayOf(8, 12, 6, 10, 10, 10), Solution().sumOfDistancesInTree(6, edges))
    }

    @Test
    fun twoNodes() {
        assertArrayEquals(intArrayOf(1, 1), Solution().sumOfDistancesInTree(2, arrayOf(intArrayOf(0, 1))))
    }

    @Test
    fun singleNode() {
        assertArrayEquals(intArrayOf(0), Solution().sumOfDistancesInTree(1, arrayOf()))
    }
}
