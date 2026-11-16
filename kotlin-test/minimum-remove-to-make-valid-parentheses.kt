package minimumremovetomakevalidparentheses

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumRemoveToMakeValidParenthesesTest {
    @Test
    fun example1() {
        assertEquals("lee(t(c)o)de", Solution().minRemoveToMakeValid("lee(t(c)o)de)"))
    }

    @Test
    fun example2() {
        assertEquals("ab(c)d", Solution().minRemoveToMakeValid("a)b(c)d"))
    }

    @Test
    fun onlyParentheses() {
        assertEquals("", Solution().minRemoveToMakeValid("))(("))
    }

    @Test
    fun noParentheses() {
        assertEquals("ab", Solution().minRemoveToMakeValid("ab"))
        assertEquals("", Solution().minRemoveToMakeValid(""))
    }

    @Test
    fun unbalancedOpen() {
        assertEquals("(a(bc)d)", Solution().minRemoveToMakeValid("(a(b(c)d)"))
    }

    @Test
    fun singleCharacters() {
        assertEquals("", Solution().minRemoveToMakeValid("("))
        assertEquals("", Solution().minRemoveToMakeValid(")"))
    }
}
