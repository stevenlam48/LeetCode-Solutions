package prisoncellsafterndays

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class PrisonCellsAfterNDaysTest {
    private val solution = Solution()

    @Test
    fun validCase1() {
        val actual = solution.prisonAfterNDays(intArrayOf(0, 1, 0, 1, 1, 0, 0, 1), 7)
        assertArrayEquals(intArrayOf(0, 0, 1, 1, 0, 0, 0, 0), actual)
    }

    @Test
    fun validCase2() {
        val actual = solution.prisonAfterNDays(intArrayOf(1, 0, 0, 1, 0, 0, 1, 0), 1000000000)
        assertArrayEquals(intArrayOf(0, 0, 1, 1, 1, 1, 1, 0), actual)
    }

    @Test
    fun validCase3_oneDay() {
        val actual = solution.prisonAfterNDays(intArrayOf(1, 1, 0, 1, 1, 0, 1, 1), 1)
        assertArrayEquals(intArrayOf(0, 0, 1, 0, 0, 1, 0, 0), actual)
    }

    @Test
    fun validCase4_fullCyclePlusOne() {
        val input = intArrayOf(0, 1, 0, 1, 1, 0, 0, 1)
        val expected = solution.prisonAfterNDays(input.copyOf(), 1)
        val actual = solution.prisonAfterNDays(input.copyOf(), 15)
        assertArrayEquals(expected, actual)
    }

    @Test
    fun validCase5_allOccupied() {
        val actual = solution.prisonAfterNDays(intArrayOf(1, 1, 1, 1, 1, 1, 1, 1), 2)
        assertArrayEquals(intArrayOf(0, 0, 1, 1, 1, 1, 0, 0), actual)
    }

    @Test
    fun validCase6_emptyPrison() {
        val actual = solution.prisonAfterNDays(IntArray(8), 4)
        assertArrayEquals(intArrayOf(0, 1, 0, 0, 0, 0, 1, 0), actual)
    }
}
