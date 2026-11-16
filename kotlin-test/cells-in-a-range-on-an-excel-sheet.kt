package cellsinarangeonanexcelsheet

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CellsInARangeOnAnExcelSheetTest {
    private val solution = Solution()

    @Test
    fun multipleColumnsAndRows() {
        assertEquals(
            listOf("K1", "K2", "L1", "L2"),
            solution.cellsInRange("K1:L2")
        )
    }

    @Test
    fun singleCell() {
        assertEquals(listOf("A1"), solution.cellsInRange("A1:A1"))
    }

    @Test
    fun oneColumn() {
        assertEquals(listOf("B3", "B4", "B5"), solution.cellsInRange("B3:B5"))
    }
}
