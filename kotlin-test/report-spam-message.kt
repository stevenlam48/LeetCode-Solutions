package reportspammessage

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class ReportSpamMessageTest {
    @Test
    fun example1() {
        assertTrue(
            Solution().reportSpam(
                listOf("hello", "world", "leetcode"),
                listOf("world", "hello")
            )
        )
    }

    @Test
    fun example2() {
        assertFalse(
            Solution().reportSpam(
                listOf("hello", "programming", "fun"),
                listOf("world", "programming", "leetcode")
            )
        )
    }

    @Test
    fun sameBannedWordTwice() {
        assertTrue(Solution().reportSpam(listOf("a", "a"), listOf("a")))
    }

    @Test
    fun singleBannedHit() {
        assertFalse(Solution().reportSpam(listOf("a", "b"), listOf("a", "c")))
    }

    @Test
    fun emptyMessage() {
        assertFalse(Solution().reportSpam(emptyList(), listOf("a")))
    }

    @Test
    fun emptyBannedList() {
        assertFalse(Solution().reportSpam(listOf("a", "b"), emptyList()))
    }
}
