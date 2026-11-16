package deletecolumnstomakesorted

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class DeleteColumnsToMakeSortedTest {
    private val solution = Solution()

    @Test
    fun oneUnsortedColumn() {
        assertEquals(1, solution.minDeletionSize(arrayOf("cba", "daf", "ghi")))
    }

    @Test
    fun alreadySorted() {
        assertEquals(0, solution.minDeletionSize(arrayOf("a", "b")))
    }

    @Test
    fun everyColumnUnsorted() {
        assertEquals(3, solution.minDeletionSize(arrayOf("zyx", "wvu", "tsr")))
    }

    @Test
    fun singleRow() {
        assertEquals(0, solution.minDeletionSize(arrayOf("anything")))
    }
}
