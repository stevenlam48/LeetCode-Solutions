package designspreadsheet

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class DesignSpreadsheetTest {
    @Test
    fun testExample() {
        val spreadsheet = Spreadsheet(3)
        spreadsheet.setCell("A1", 5)
        spreadsheet.setCell("B2", 3)
        assertEquals(8, spreadsheet.getValue("=A1+B2"))
        spreadsheet.resetCell("A1")
        assertEquals(3, spreadsheet.getValue("=A1+B2"))
        assertEquals(12, spreadsheet.getValue("=5+7"))
    }

    @Test
    fun testNumericLiterals() {
        val spreadsheet = Spreadsheet(1)
        assertEquals(0, spreadsheet.getValue("=0+0"))
        assertEquals(1000000, spreadsheet.getValue("=999999+1"))
    }

    @Test
    fun testOverwriteCell() {
        val spreadsheet = Spreadsheet(2)
        spreadsheet.setCell("C3", 10)
        assertEquals(10, spreadsheet.getValue("=C3+0"))
        spreadsheet.setCell("C3", 20)
        assertEquals(20, spreadsheet.getValue("=0+C3"))
    }

    @Test
    fun testResetUnknownCell() {
        val spreadsheet = Spreadsheet(2)
        spreadsheet.resetCell("Z9")
        assertEquals(0, spreadsheet.getValue("=Z9+Z9"))
    }

    @Test
    fun testBothCellsReferenced() {
        val spreadsheet = Spreadsheet(2)
        spreadsheet.setCell("A1", 7)
        spreadsheet.setCell("B1", 8)
        assertEquals(15, spreadsheet.getValue("=A1+B1"))
        assertEquals(15, spreadsheet.getValue("=B1+A1"))
    }
}
