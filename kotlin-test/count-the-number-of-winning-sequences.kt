package countthenumberofwinningsequences

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CountTheNumberOfWinningSequencesTest {
    private val solution = Solution()

    @Test
    fun `first leetcode example`() {
        assertEquals(3, solution.countWinningSequences("FFF"))
    }

    @Test
    fun `second leetcode example`() {
        assertEquals(18, solution.countWinningSequences("FWEFW"))
    }

    @Test
    fun `every single round has one winning response`() {
        assertEquals(1, solution.countWinningSequences("F"))
        assertEquals(1, solution.countWinningSequences("W"))
        assertEquals(1, solution.countWinningSequences("E"))
    }

    @Test
    fun `two rounds with the same opponent move`() {
        assertEquals(2, solution.countWinningSequences("WW"))
    }

    @Test
    fun `two rounds with different opponent moves`() {
        assertEquals(2, solution.countWinningSequences("FW"))
    }

    @Test
    fun `empty sequence has no winning sequence`() {
        assertEquals(0, solution.countWinningSequences(""))
    }
}
