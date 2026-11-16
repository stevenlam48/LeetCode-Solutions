package reversesubstringsbetweeneachpairofparentheses

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ReverseSubstringsBetweenEachPairOfParenthesesTest {
    @Test
    fun singlePair() {
        assertEquals("dcba", Solution().reverseParentheses("(abcd)"))
    }

    @Test
    fun nestedPair() {
        assertEquals("iloveu", Solution().reverseParentheses("(u(love)i)"))
    }

    @Test
    fun doublyNestedPair() {
        assertEquals("leetcode", Solution().reverseParentheses("(ed(et(oc))el)"))
    }

    @Test
    fun noParentheses() {
        assertEquals("abc", Solution().reverseParentheses("abc"))
    }
}
