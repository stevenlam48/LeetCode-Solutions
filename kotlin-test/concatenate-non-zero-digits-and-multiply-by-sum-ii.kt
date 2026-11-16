package concatenatenonzerodigitsandmultiplybysumii

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class ConcatenateNonZeroDigitsAndMultiplyBySumIITest {
    @Test
    fun answersWholeAndPartialRangeQueries() {
        val queries = arrayOf(
            intArrayOf(0, 7),
            intArrayOf(0, 3),
            intArrayOf(4, 6),
            intArrayOf(0, 4),
        )
        assertArrayEquals(intArrayOf(12340, 36, 9, 738), Solution().sumAndMultiply("10203004", queries))
    }

    @Test
    fun returnsZeroWhenRangeHasNoNonZeroDigits() {
        val queries = arrayOf(intArrayOf(1, 1), intArrayOf(0, 2))
        assertArrayEquals(intArrayOf(0, 0), Solution().sumAndMultiply("000", queries))
    }

    @Test
    fun appliesModuloToLongValues() {
        val result = Solution().sumAndMultiply("98765432199", arrayOf(intArrayOf(0, 10)))
        assertArrayEquals(intArrayOf(222184983), result)
    }
}
