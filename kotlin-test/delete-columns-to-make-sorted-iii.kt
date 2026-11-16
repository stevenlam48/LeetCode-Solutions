package deletecolumnstomakesortediii

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class DeleteColumnsToMakeSortedIiiTest {
    private val solution = Solution()

    @Test
    fun longestCompatibleColumns() {
        assertEquals(3, solution.minDeletionSize(arrayOf("babca", "bbazb")))
    }

    @Test
    fun singleDescendingRow() {
        assertEquals(4, solution.minDeletionSize(arrayOf("edcba")))
    }

    @Test
    fun everyColumnNondecreasing() {
        assertEquals(0, solution.minDeletionSize(arrayOf("ghi", "def", "abc")))
    }

    @Test
    fun equalCharactersCanRemain() {
        assertEquals(2, solution.minDeletionSize(arrayOf("aab", "aba", "baa")))
    }
}
