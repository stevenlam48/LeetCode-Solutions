package numberofwaystopaintsheets

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class NumberOfWaysToPaintSheetsTest {
    @Test
    fun equalLimits() {
        assertEquals(4, Solution().numberOfWays(3, intArrayOf(2, 2)))
    }

    @Test
    fun mixedLimits() {
        assertEquals(8, Solution().numberOfWays(3, intArrayOf(1, 2, 2)))
    }

    @Test
    fun identicalSheets() {
        assertEquals(6, Solution().numberOfWays(2, intArrayOf(1, 1, 1)))
    }

    @Test
    fun singleSheetCannotBePaired() {
        assertEquals(0, Solution().numberOfWays(5, intArrayOf(10)))
    }
}
