package reversestring

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class ReverseStringTest {
    @Test
    fun hello() {
        val chars = charArrayOf('h', 'e', 'l', 'l', 'o')
        Solution().reverseString(chars)
        assertArrayEquals(charArrayOf('o', 'l', 'l', 'e', 'h'), chars)
    }

    @Test
    fun evenLength() {
        val chars = charArrayOf('H', 'a', 'n', 'n', 'a', 'h')
        Solution().reverseString(chars)
        assertArrayEquals(charArrayOf('h', 'a', 'n', 'n', 'a', 'H'), chars)
    }

    @Test
    fun singleCharacter() {
        val chars = charArrayOf('a')
        Solution().reverseString(chars)
        assertArrayEquals(charArrayOf('a'), chars)
    }

    @Test
    fun emptyArray() {
        val chars = charArrayOf()
        Solution().reverseString(chars)
        assertArrayEquals(charArrayOf(), chars)
    }
}
