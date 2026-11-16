package designsql

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class DesignSqlTest {
    @Test
    fun testExample() {
        val sql = SQL(listOf("Student", "Enroll"), intArrayOf(2, 2))
        sql.insertRow("Student", listOf("1", "A"))
        sql.insertRow("Student", listOf("2", "B"))
        sql.insertRow("Enroll", listOf("1", "Math"))
        assertEquals("1", sql.selectCell("Student", 1, 1))
        assertEquals("A", sql.selectCell("Student", 1, 2))
        sql.deleteRow("Student", 1)
        assertEquals("", sql.selectCell("Student", 1, 1))
        assertEquals("Math", sql.selectCell("Enroll", 1, 2))
    }

    @Test
    fun testMultipleColumns() {
        val sql = SQL(listOf("T"), intArrayOf(3))
        sql.insertRow("T", listOf("a", "b", "c"))
        assertEquals("a", sql.selectCell("T", 1, 1))
        assertEquals("b", sql.selectCell("T", 1, 2))
        assertEquals("c", sql.selectCell("T", 1, 3))
    }

    @Test
    fun testDeleteTwice() {
        val sql = SQL(listOf("T"), intArrayOf(1))
        sql.insertRow("T", listOf("x"))
        sql.deleteRow("T", 1)
        sql.deleteRow("T", 1)
        assertEquals("", sql.selectCell("T", 1, 1))
    }

    @Test
    fun testRowsAreIndependent() {
        val sql = SQL(listOf("T"), intArrayOf(1))
        sql.insertRow("T", listOf("r0"))
        sql.insertRow("T", listOf("r1"))
        sql.insertRow("T", listOf("r2"))
        sql.deleteRow("T", 2)
        assertEquals("r0", sql.selectCell("T", 1, 1))
        assertEquals("", sql.selectCell("T", 2, 1))
        assertEquals("r2", sql.selectCell("T", 3, 1))
    }
}
