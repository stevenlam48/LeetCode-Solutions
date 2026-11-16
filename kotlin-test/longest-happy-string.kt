package longesthappystring

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Test

class LongestHappyStringTest {
    private val solution = Solution()

    @Test
    fun standardExample() {
        val result = solution.longestDiverseString(1, 1, 3)
        assertEquals("ccbca", result)
        assertFalse(result.contains("aaa") || result.contains("bbb") || result.contains("ccc"))
    }

    @Test
    fun balancedCounts() {
        assertEquals("cbacba", solution.longestDiverseString(2, 2, 2))
    }

    @Test
    fun onlyOneCharacterAvailable() {
        assertEquals("aa", solution.longestDiverseString(7, 0, 0))
    }

    @Test
    fun tieBreaksByCharacter() {
        assertEquals("ba", solution.longestDiverseString(1, 1, 0))
    }

    @Test
    fun allCountsZero() {
        assertEquals("", solution.longestDiverseString(0, 0, 0))
    }
}
