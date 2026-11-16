package scoreofparentheses

// Time:  O(n)
// Space: O(1)

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ScoreOfParenthesesTest {
    @Test
    fun singlePair() {
        assertEquals(1, Solution().scoreOfParentheses("()"))
    }

    @Test
    fun nestedPair() {
        assertEquals(2, Solution().scoreOfParentheses("(())"))
    }

    @Test
    fun adjacentPairs() {
        assertEquals(2, Solution().scoreOfParentheses("()()"))
    }

    @Test
    fun mixedStructure() {
        assertEquals(6, Solution().scoreOfParentheses("(()(()))"))
    }

    @Test
    fun deepNesting() {
        assertEquals(16, Solution().scoreOfParentheses("((((()))))"))
    }
}
