package transformbinarystringusingsubsequencesort

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class TransformBinaryStringUsingSubsequenceSortTest {
    @Test
    fun acceptsExactAndSortablePatterns() {
        val result = Solution().transformStr("0101", listOf("0101", "0011", "011"))
        assertArrayEquals(booleanArrayOf(true, true, false), result)
    }

    @Test
    fun rejectsImpossibleOneCounts() {
        val result = Solution().transformStr("0101", listOf("111", "000", "0"))
        assertArrayEquals(booleanArrayOf(false, false, false), result)
    }

    @Test
    fun emptySourceAndEmptyPattern() {
        assertArrayEquals(booleanArrayOf(true), Solution().transformStr("", listOf("")))
    }
}
