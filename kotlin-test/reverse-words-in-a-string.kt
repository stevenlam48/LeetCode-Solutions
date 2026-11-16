package reversewordsinastring

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ReverseWordsInAStringTest {
    @Test
    fun exampleOne() {
        assertEquals("blue is sky the", Solution().reverseWords("the sky is blue"))
    }

    @Test
    fun surroundingSpaces() {
        assertEquals("world hello", Solution().reverseWords("  hello world  "))
    }

    @Test
    fun repeatedInternalSpaces() {
        assertEquals("example good a", Solution().reverseWords("a good   example"))
    }

    @Test
    fun spacesOnly() {
        assertEquals("", Solution().reverseWords("   "))
    }
}
