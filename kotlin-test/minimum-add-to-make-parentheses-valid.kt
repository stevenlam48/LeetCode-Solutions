package minimumaddtomakeparenthesesvalid

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumAddToMakeParenthesesValidTest {
    @Test
    fun example1() {
        assertEquals(1, Solution().minAddToMakeValid("())"))
    }

    @Test
    fun example2() {
        assertEquals(3, Solution().minAddToMakeValid("((("))
    }

    @Test
    fun balanced() {
        assertEquals(0, Solution().minAddToMakeValid("()"))
    }

    @Test
    fun mixed() {
        assertEquals(4, Solution().minAddToMakeValid("()))(("))
    }

    @Test
    fun empty() {
        assertEquals(0, Solution().minAddToMakeValid(""))
    }
}
