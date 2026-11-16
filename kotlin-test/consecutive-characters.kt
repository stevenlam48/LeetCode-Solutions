package consecutivecharacters

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ConsecutiveCharactersTest {
    @Test
    fun matchesLeetCodeExamples() {
        assertEquals(2, Solution().maxPower("leetcode"))
        assertEquals(5, Solution().maxPower("abbcccddddeeeeedcba"))
    }

    @Test
    fun handlesEntireStringAsOneRun() {
        assertEquals(1, Solution().maxPower("a"))
        assertEquals(6, Solution().maxPower("zzzzzz"))
    }

    @Test
    fun tracksRunsSeparatedByDifferentCharacters() {
        assertEquals(3, Solution().maxPower("abbaaacc"))
    }
}
