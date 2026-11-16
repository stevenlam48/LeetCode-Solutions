package generateparentheses

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class GenerateParenthesesTest {
    private fun isValid(s: String): Boolean {
        var balance = 0
        for (c in s) {
            if (c == '(') {
                ++balance
            } else {
                --balance
                if (balance < 0) {
                    return false
                }
            }
        }
        return balance == 0
    }

    @Test
    fun onePair() {
        assertEquals(listOf("()"), Solution().generateParentheses(1))
    }

    @Test
    fun twoPairs() {
        assertEquals(setOf("(())", "()()"), Solution().generateParentheses(2).toSet())
    }

    @Test
    fun threePairs() {
        val expected = setOf("((()))", "(()())", "(())()", "()(())", "()()()")
        val actual = Solution().generateParentheses(3)
        assertEquals(5, actual.size)
        assertEquals(expected, actual.toSet())
    }

    @Test
    fun fourPairsCountAndValidity() {
        val actual = Solution().generateParentheses(4)
        assertEquals(14, actual.size)
        assertEquals(14, actual.toSet().size)
        for (s in actual) {
            assertEquals(8, s.length)
            assertTrue(isValid(s))
        }
    }
}
