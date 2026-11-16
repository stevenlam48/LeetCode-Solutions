package minimumheighttrees

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class MinimumHeightTreesTest {
    @Test
    fun example1() {
        val edges = arrayOf(intArrayOf(1, 0), intArrayOf(1, 2), intArrayOf(1, 3))
        assertArrayEquals(intArrayOf(1), Solution().findMinHeightTrees(4, edges))
    }

    @Test
    fun example2() {
        val edges = arrayOf(
            intArrayOf(3, 0),
            intArrayOf(3, 1),
            intArrayOf(3, 2),
            intArrayOf(3, 4),
            intArrayOf(5, 4)
        )
        assertArrayEquals(intArrayOf(3, 4), Solution().findMinHeightTrees(6, edges).sortedArray())
    }

    @Test
    fun singleNode() {
        assertArrayEquals(intArrayOf(0), Solution().findMinHeightTrees(1, arrayOf()))
    }

    @Test
    fun twoNodes() {
        val edges = arrayOf(intArrayOf(0, 1))
        assertArrayEquals(intArrayOf(0, 1), Solution().findMinHeightTrees(2, edges).sortedArray())
    }
}
