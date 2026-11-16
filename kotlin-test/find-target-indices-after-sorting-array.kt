package findtargetindicesaftersortingarray

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class FindTargetIndicesAfterSortingArrayTest {
    @Test
    fun findsAllTargetIndices() {
        assertArrayEquals(intArrayOf(1, 2), Solution().targetIndices(intArrayOf(1, 2, 5, 2, 3), 2))
    }

    @Test
    fun findsSingleTargetAfterSorting() {
        assertArrayEquals(intArrayOf(3), Solution().targetIndices(intArrayOf(1, 2, 5, 2, 3), 3))
    }

    @Test
    fun returnsEmptyWhenTargetIsAbsent() {
        assertArrayEquals(intArrayOf(), Solution().targetIndices(intArrayOf(1, 2, 5, 2, 3), 4))
    }

    @Test
    fun handlesDuplicatesAndNegativeValues() {
        assertArrayEquals(intArrayOf(0, 1, 2), Solution().targetIndices(intArrayOf(-1, -1, 0, -1), -1))
    }
}
