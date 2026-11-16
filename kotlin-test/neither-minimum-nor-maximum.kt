package neitherminimumnormaximum

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class NeitherMinimumNorMaximumTest {
    @Test
    fun `returns value between minimum and maximum`() {
        assertEquals(3, Solution().findNonMinOrMax(intArrayOf(3, 2, 1, 4)))
    }

    @Test
    fun `returns middle value in decreasing input`() {
        assertEquals(2, Solution().findNonMinOrMax(intArrayOf(3, 2, 1)))
    }

    @Test
    fun `returns minus one for fewer than three values`() {
        assertEquals(-1, Solution().findNonMinOrMax(intArrayOf(1, 2)))
        assertEquals(-1, Solution().findNonMinOrMax(intArrayOf(2)))
    }

    @Test
    fun `returns minus one when all values are equal`() {
        assertEquals(-1, Solution().findNonMinOrMax(intArrayOf(1, 1, 1)))
    }
}
