package removeadjacentalmostequalcharacters

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class RemoveAdjacentAlmostEqualCharactersTest {
    @Test
    fun repeatedCharacters() {
        assertEquals(2, Solution().removeAlmostEqualCharacters("aaaaa"))
    }

    @Test
    fun standardMixedExample() {
        assertEquals(2, Solution().removeAlmostEqualCharacters("abddez"))
    }

    @Test
    fun consecutiveAlphabet() {
        assertEquals(2, Solution().removeAlmostEqualCharacters("abcde"))
    }

    @Test
    fun noAlmostEqualNeighbors() {
        assertEquals(0, Solution().removeAlmostEqualCharacters("azby"))
    }

    @Test
    fun emptyAndSingleCharacter() {
        assertEquals(0, Solution().removeAlmostEqualCharacters(""))
        assertEquals(0, Solution().removeAlmostEqualCharacters("a"))
    }
}
