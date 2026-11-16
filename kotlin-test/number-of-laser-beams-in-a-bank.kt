package numberoflaserbeamsinabank

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class NumberOfLaserBeamsInABankTest {
    @Test
    fun countsBeamsAcrossNonemptyRows() {
        val bank = listOf("011001", "000000", "010100", "001000")
        assertEquals(8, Solution().numberOfBeams(bank))
    }

    @Test
    fun returnsZeroWithFewerThanTwoDeviceRows() {
        assertEquals(0, Solution().numberOfBeams(listOf("000", "111", "000")))
        assertEquals(0, Solution().numberOfBeams(listOf("000", "000")))
    }

    @Test
    fun returnsZeroForEmptyBank() {
        assertEquals(0, Solution().numberOfBeams(emptyList()))
    }

    @Test
    fun skipsRowsWithoutDevices() {
        val bank = listOf("101", "000", "11")
        assertEquals(4, Solution().numberOfBeams(bank))
    }
}
