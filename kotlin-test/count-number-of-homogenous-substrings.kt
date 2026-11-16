package countnumberofhomogenoussubstrings

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CountNumberOfHomogenousSubstringsTest {
    @Test
    fun multipleRunsExample() {
        assertEquals(13, Solution().countHomogenous("abbcccaa"))
    }

    @Test
    fun allHomogenousExample() {
        assertEquals(15, Solution().countHomogenous("zzzzz"))
    }

    @Test
    fun distinctAdjacentCharactersOnlyCountSingleCharacters() {
        assertEquals(2, Solution().countHomogenous("xy"))
    }

    @Test
    fun emptyStringHasNoSubstrings() {
        assertEquals(0, Solution().countHomogenous(""))
    }

    @Test
    fun longRunAppliesModulo() {
        assertEquals(49_965, Solution().countHomogenous("z".repeat(100_000)))
    }
}
