package numberofislandsii

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class NumberOfIslandsIITest {
    @Test
    fun returnsEmptyResultWithoutPositions() {
        assertArrayEquals(intArrayOf(), Solution().numIslands2(3, 3, emptyArray()))
    }

    @Test
    fun countsSingleAddedLand() {
        val positions = arrayOf(Pair(1, 1))
        assertArrayEquals(intArrayOf(1), Solution().numIslands2(3, 3, positions))
    }

    @Test
    fun tracksGrowingSetOfIslands() {
        val positions = arrayOf(Pair(0, 0), Pair(0, 1), Pair(1, 2), Pair(2, 1))
        assertArrayEquals(intArrayOf(1, 1, 2, 3), Solution().numIslands2(3, 3, positions))
    }

    @Test
    fun mergesTwoIslandsThroughNewLand() {
        val positions = arrayOf(Pair(0, 0), Pair(1, 1), Pair(0, 1))
        assertArrayEquals(intArrayOf(1, 2, 1), Solution().numIslands2(2, 2, positions))
    }
}
