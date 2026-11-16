package mergeadjacentequalelements

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class MergeAdjacentEqualElementsTest {
    @Test
    fun cascadedMerges() {
        assertArrayEquals(longArrayOf(16), Solution().mergeAdjacent(intArrayOf(2, 2, 4, 8)))
    }

    @Test
    fun mergeOnlyNewAdjacentPairs() {
        assertArrayEquals(longArrayOf(1, 4, 3), Solution().mergeAdjacent(intArrayOf(1, 2, 2, 3)))
        assertArrayEquals(longArrayOf(8, 4), Solution().mergeAdjacent(intArrayOf(2, 2, 2, 2, 4)))
    }

    @Test
    fun noEqualAdjacentElements() {
        assertArrayEquals(longArrayOf(1, 2, 3), Solution().mergeAdjacent(intArrayOf(1, 2, 3)))
    }

    @Test
    fun emptyInput() {
        assertArrayEquals(longArrayOf(), Solution().mergeAdjacent(intArrayOf()))
    }
}
