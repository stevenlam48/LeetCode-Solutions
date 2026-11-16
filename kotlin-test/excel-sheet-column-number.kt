package excelsheetcolumnnumber

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ExcelSheetColumnNumberTest {
    @Test
    fun singleLetterColumns() {
        val solution = Solution()
        assertEquals(1, solution.titleToNumber("A"))
        assertEquals(26, solution.titleToNumber("Z"))
    }

    @Test
    fun twoLetterExample() {
        assertEquals(28, Solution().titleToNumber("AB"))
    }

    @Test
    fun largerExample() {
        assertEquals(701, Solution().titleToNumber("ZY"))
    }

    @Test
    fun rolloverToThreeLetters() {
        assertEquals(703, Solution().titleToNumber("AAA"))
    }
}
