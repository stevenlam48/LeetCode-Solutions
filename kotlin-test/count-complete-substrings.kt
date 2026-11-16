package countcompletesubstrings

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CountCompleteSubstringsTest {
    @Test
    fun examples() {
        assertEquals(3, Solution().countCompleteSubstrings("igigee", 2))
        assertEquals(6, Solution().countCompleteSubstrings("aaabbbccc", 3))
    }

    @Test
    fun singleCharacterWindows() {
        assertEquals(1, Solution().countCompleteSubstrings("a", 1))
        assertEquals(2, Solution().countCompleteSubstrings("aa", 1))
    }

    @Test
    fun noCompleteSubstrings() {
        assertEquals(0, Solution().countCompleteSubstrings("a", 2))
    }
}
