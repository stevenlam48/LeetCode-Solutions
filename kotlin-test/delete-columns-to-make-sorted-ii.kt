package deletecolumnstomakesortedii

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class DeleteColumnsToMakeSortedIiTest {
    private val solution = Solution()

    @Test
    fun keepsLaterColumnAfterEarlyOrdering() {
        assertEquals(1, solution.minDeletionSize(arrayOf("ca", "bb", "ac")))
    }

    @Test
    fun lexicographicallySortedRows() {
        assertEquals(0, solution.minDeletionSize(arrayOf("xc", "yb", "za")))
    }

    @Test
    fun allColumnsDeleted() {
        assertEquals(3, solution.minDeletionSize(arrayOf("zyx", "wvu", "tsr")))
    }

    @Test
    fun singleRowAndDuplicateRows() {
        assertEquals(0, solution.minDeletionSize(arrayOf("single")))
        assertEquals(0, solution.minDeletionSize(arrayOf("ab", "ab", "ba")))
    }
}
