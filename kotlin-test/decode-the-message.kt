package decodethemessage

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class DecodeTheMessageTest {
    @Test
    fun example1() {
        val key = "the quick brown fox jumps over the lazy dog"
        assertEquals("this is a secret", Solution().decodeMessage(key, "vkbs bs t suepuv"))
    }

    @Test
    fun example2() {
        val key = "eljuxhpwnyrdgtqkviszcfmabo"
        assertEquals(
            "the five boxing wizards jump quickly",
            Solution().decodeMessage(key, "zwx hnfx lqantp mnoeius ycgk vcnjrdb")
        )
    }

    @Test
    fun alphabetKey() {
        assertEquals("abc def", Solution().decodeMessage("abcdefghijklmnopqrstuvwxyz", "abc def"))
    }

    @Test
    fun emptyMessage() {
        assertEquals("", Solution().decodeMessage("abc", ""))
    }

    @Test
    fun repeatedKeyLetters() {
        assertEquals("abc", Solution().decodeMessage("aaabbbcccdefghijklmnopqrstuvwxyz", "abc"))
    }
}
