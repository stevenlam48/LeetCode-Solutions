package freedomtrail

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FreedomTrailTest {
    private val solution = Solution()

    @Test
    fun shortestRotationToSeparateCharacters() {
        assertEquals(4, solution.findRotateSteps("godding", "gd"))
    }

    @Test
    fun spellEntireRing() {
        assertEquals(13, solution.findRotateSteps("godding", "godding"))
    }

    @Test
    fun emptyKeyNeedsNoSteps() {
        assertEquals(0, solution.findRotateSteps("godding", ""))
    }

    @Test
    fun singleCharacterRingOnlyNeedsPresses() {
        assertEquals(4, solution.findRotateSteps("a", "aaaa"))
    }

    @Test
    fun returnToEarlierCharacter() {
        assertEquals(5, solution.findRotateSteps("ab", "aba"))
    }
}
