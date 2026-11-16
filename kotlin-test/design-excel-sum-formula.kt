package designexcelsumformula

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class DesignExcelSumFormulaTest {
    @Test
    fun leetCodeExample() {
        val excel = Excel(3, 'C')
        excel.set(1, 'A', 2)
        assertEquals(4, excel.sum(3, 'C', listOf("A1", "A1:B2")))
        excel.set(2, 'B', 2)
        assertEquals(6, excel.get(3, 'C'))
    }

    @Test
    fun changingBaseCellUpdatesDependentFormula() {
        val excel = Excel(5, 'D')
        excel.set(1, 'A', 3)
        excel.set(2, 'A', 4)
        assertEquals(7, excel.sum(3, 'A', listOf("A1:A2")))
        excel.set(1, 'A', 10)
        assertEquals(14, excel.get(3, 'A'))
    }

    @Test
    fun resettingFormulaRemovesOldDependencies() {
        val excel = Excel(5, 'C')
        excel.set(1, 'A', 2)
        excel.sum(2, 'A', listOf("A1"))
        excel.set(1, 'B', 5)
        assertEquals(5, excel.sum(2, 'A', listOf("B1")))
        excel.set(1, 'A', 20)
        assertEquals(5, excel.get(2, 'A'))
        excel.set(1, 'B', 6)
        assertEquals(6, excel.get(2, 'A'))
    }

    @Test
    fun overlappingRangesCountCellsRepeatedlyAndPropagate() {
        val excel = Excel(5, 'C')
        excel.set(1, 'A', 2)
        assertEquals(6, excel.sum(2, 'A', listOf("A1", "A1:B1", "A1")))
        excel.sum(3, 'A', listOf("A2"))
        excel.set(1, 'A', 5)
        assertEquals(15, excel.get(2, 'A'))
        assertEquals(15, excel.get(3, 'A'))
    }
}
