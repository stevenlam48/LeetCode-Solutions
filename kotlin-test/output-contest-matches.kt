package outputcontestmatches

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class OutputContestMatchesTest {
    private val solution = Solution()

    @Test
    fun twoTeams() {
        assertEquals("(1,2)", solution.findContestMatch(2))
    }

    @Test
    fun fourTeams() {
        assertEquals("((1,4),(2,3))", solution.findContestMatch(4))
    }

    @Test
    fun eightTeams() {
        assertEquals("(((1,8),(4,5)),((2,7),(3,6)))", solution.findContestMatch(8))
    }
}
