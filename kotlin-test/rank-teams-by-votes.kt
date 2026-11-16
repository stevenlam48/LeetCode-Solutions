package rankteamsbyvotes
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class RankTeamsByVotesTest {
    @Test
    fun leetCodeExamples() {
        assertEquals("ACB", Solution().rankTeams(listOf("ABC", "ACB", "ABC", "ACB", "ACB")))
        assertEquals("XWYZ", Solution().rankTeams(listOf("WXYZ", "XYZW")))
        assertEquals("ZMNAGUEDSJYLBOPHRQICWFXTVK", Solution().rankTeams(listOf("ZMNAGUEDSJYLBOPHRQICWFXTVK")))
    }

    @Test
    fun allPositionsTieBreakLexicographically() {
        assertEquals("ABC", Solution().rankTeams(listOf("BCA", "CAB", "ABC")))
    }

    @Test
    fun headToHeadDecidesBeforeLowerRanks() {
        assertEquals("BAC", Solution().rankTeams(listOf("BAC", "BCA", "ACB")))
    }
}
