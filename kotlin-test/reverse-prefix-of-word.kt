package reverseprefixofword

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ReversePrefixOfWordTest {
    @Test
    fun exampleOne() {
        assertEquals("dcbaefd", Solution().reversePrefix("abcdefd", 'd'))
    }

    @Test
    fun exampleTwo() {
        assertEquals("zxyxxe", Solution().reversePrefix("xyxzxe", 'z'))
    }

    @Test
    fun characterIsAbsent() {
        assertEquals("abcd", Solution().reversePrefix("abcd", 'z'))
    }

    @Test
    fun firstCharacter() {
        assertEquals("abcd", Solution().reversePrefix("abcd", 'a'))
    }
}
