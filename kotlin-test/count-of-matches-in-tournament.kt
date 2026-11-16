package countofmatchesintournament

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class CountOfMatchesInTournamentTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertEquals(6, solution.numberOfMatches(7))
    }

    @Test
    fun testExample2() {
        assertEquals(13, solution.numberOfMatches(14))
    }

    @Test
    fun testSingleTeam() {
        assertEquals(0, solution.numberOfMatches(1))
    }

    @Test
    fun testTwoTeams() {
        assertEquals(1, solution.numberOfMatches(2))
    }
}
