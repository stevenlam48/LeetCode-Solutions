package excelsheetcolumntitle

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ExcelSheetColumnTitleTest {
    @Test
    fun singleLetterColumns() {
        val solution = Solution()
        assertEquals("A", solution.convertToTitle(1))
        assertEquals("Z", solution.convertToTitle(26))
    }

    @Test
    fun firstTwoLetterColumns() {
        val solution = Solution()
        assertEquals("AA", solution.convertToTitle(27))
        assertEquals("AB", solution.convertToTitle(28))
    }

    @Test
    fun largerExample() {
        assertEquals("ZY", Solution().convertToTitle(701))
    }

    @Test
    fun rolloverToThreeLetters() {
        assertEquals("AAA", Solution().convertToTitle(703))
    }
}
