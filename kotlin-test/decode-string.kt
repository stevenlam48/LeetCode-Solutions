package decodestring

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class DecodeStringTest {
    @Test
    fun example1() {
        assertEquals("aaabcbc", Solution().decodeString("3[a]2[bc]"))
    }

    @Test
    fun example2() {
        assertEquals("accaccacc", Solution().decodeString("3[a2[c]]"))
    }

    @Test
    fun example3() {
        assertEquals("abcabccdcdcdef", Solution().decodeString("2[abc]3[cd]ef"))
    }

    @Test
    fun trailingLiteral() {
        assertEquals("abccdcdcdxyz", Solution().decodeString("abc3[cd]xyz"))
    }

    @Test
    fun multiDigitRepeat() {
        assertEquals("aaaaaaaaaa", Solution().decodeString("10[a]"))
    }

    @Test
    fun emptyAndPlain() {
        assertEquals("", Solution().decodeString(""))
        assertEquals("leetcode", Solution().decodeString("leetcode"))
    }
}
