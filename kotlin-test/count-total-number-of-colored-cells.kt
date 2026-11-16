package counttotalnumberofcoloredcells

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CountTotalNumberOfColoredCellsTest {
    @Test
    fun singleMinute() {
        assertEquals(1L, Solution().coloredCells(1))
    }

    @Test
    fun twoMinutes() {
        assertEquals(5L, Solution().coloredCells(2))
    }

    @Test
    fun threeMinutes() {
        assertEquals(13L, Solution().coloredCells(3))
    }

    @Test
    fun largeInputUsesLongArithmetic() {
        assertEquals(19_999_800_001L, Solution().coloredCells(100_000))
    }
}
