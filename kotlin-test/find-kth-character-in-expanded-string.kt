package findkthcharacterinexpandedstring

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FindKthCharacterInExpandedStringTest {
    @Test
    fun findsCharactersWithinRepeatedWords() {
        assertEquals('a', Solution().kthCharacter("ab cd", 0))
        assertEquals('b', Solution().kthCharacter("ab cd", 2))
        assertEquals('c', Solution().kthCharacter("ab cd", 4))
        assertEquals('d', Solution().kthCharacter("ab cd", 6))
    }

    @Test
    fun countsSpacesAsSingleCharacters() {
        assertEquals(' ', Solution().kthCharacter("ab cd", 3))
    }

    @Test
    fun resetsRepetitionLengthAfterEachSpace() {
        assertEquals('b', Solution().kthCharacter("a ab", 4))
    }
}
