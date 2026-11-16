package reversewordsinastringii

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ReverseWordsInAStringIiTest {
    @Test
    fun example() {
        assertEquals("blue is sky the", Solution().reverseWords("the sky is blue"))
    }

    @Test
    fun singleWord() {
        assertEquals("hello", Solution().reverseWords("hello"))
    }

    @Test
    fun spacesArePreserved() {
        assertEquals("world  hello ", Solution().reverseWords(" hello  world"))
    }

    @Test
    fun emptyString() {
        assertEquals("", Solution().reverseWords(""))
    }
}
