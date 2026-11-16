package reversestringprefix

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ReverseStringPrefixTest {
    @Test
    fun exampleOne() {
        assertEquals("cbad", Solution().reversePrefix("abcd", 3))
    }

    @Test
    fun wholeString() {
        assertEquals("dcba", Solution().reversePrefix("abcd", 4))
    }

    @Test
    fun prefixOfOne() {
        assertEquals("abcd", Solution().reversePrefix("abcd", 1))
    }

    @Test
    fun prefixInLongerString() {
        assertEquals("bacdef", Solution().reversePrefix("abcdef", 2))
    }
}
