package regionscutbyslashes

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class RegionsCutBySlashesTest {
    @Test
    fun twoOppositeSlashes() {
        assertEquals(2, Solution().regionsBySlashes(listOf(" /", "/ ")))
    }

    @Test
    fun oneSlashAndBlankCell() {
        assertEquals(1, Solution().regionsBySlashes(listOf(" /", "  ")))
    }

    @Test
    fun fourSlashes() {
        assertEquals(4, Solution().regionsBySlashes(listOf("\\/", "/\\")))
    }

    @Test
    fun singleCells() {
        assertEquals(2, Solution().regionsBySlashes(listOf("/")))
        assertEquals(2, Solution().regionsBySlashes(listOf("\\")))
        assertEquals(1, Solution().regionsBySlashes(listOf(" ")))
    }

    @Test
    fun emptyGrid() {
        assertEquals(0, Solution().regionsBySlashes(emptyList()))
    }
}
