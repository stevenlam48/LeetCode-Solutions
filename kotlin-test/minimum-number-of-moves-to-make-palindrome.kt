package minimumnumberofmovestomakepalindrome

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumNumberOfMovesToMakePalindromeTest {
    private val solution = Solution()

    @Test
    fun twoPairs() {
        assertEquals(2, solution.minMovesToMakePalindrome("aabb"))
    }

    @Test
    fun interleavedPairs() {
        assertEquals(2, solution.minMovesToMakePalindrome("letelt"))
    }

    @Test
    fun oddLengthPalindrome() {
        assertEquals(3, solution.minMovesToMakePalindrome("mamad"))
    }

    @Test
    fun singleCharacter() {
        assertEquals(0, solution.minMovesToMakePalindrome("a"))
    }

    @Test
    fun alreadyPalindrome() {
        assertEquals(0, solution.minMovesToMakePalindrome("racecar"))
    }
}
