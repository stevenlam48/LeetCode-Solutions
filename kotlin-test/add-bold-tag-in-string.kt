package addboldtaginstring

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class PaddboldtaginstringTest {
    @Test
    fun example1() {
        assertEquals(
            "<b>abc</b>xyz<b>123</b>",
            Solution().addBoldTag("abcxyz123", listOf("abc", "123"))
        )
    }

    @Test
    fun example2() {
        assertEquals(
            "<b>aaabbb</b>",
            Solution().addBoldTag("aaabbb", listOf("aa", "b"))
        )
    }

    @Test
    fun overlapping() {
        assertEquals(
            "<b>aaabbbb</b>",
            Solution().addBoldTag("aaabbbb", listOf("aa", "bb"))
        )
    }

    @Test
    fun noMatch() {
        assertEquals("abc", Solution().addBoldTag("abc", listOf("xyz")))
    }

    @Test
    fun emptyDict() {
        assertEquals("abc", Solution().addBoldTag("abc", emptyList()))
    }

    @Test
    fun wholeString() {
        assertEquals("<b>abc</b>", Solution().addBoldTag("abc", listOf("abc")))
    }
}
