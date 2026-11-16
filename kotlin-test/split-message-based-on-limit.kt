package splitmessagebasedonlimit

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class SplitMessageBasedOnLimitTest {
    private val solution = Solution()

    @Test
    fun `splits the example message at the limit`() {
        assertEquals(
            listOf("this is r<1/5>", "eally a v<2/5>", "ery aweso<3/5>", "me messag<4/5>", "e<5/5>"),
            solution.splitMessage("this is really a very awesome message", 14)
        )
    }

    @Test
    fun `returns one part when the message and suffix exactly fit`() {
        assertEquals(listOf("abc<1/1>"), solution.splitMessage("abc", 8))
    }

    @Test
    fun `returns no parts when the suffix cannot fit`() {
        assertEquals(emptyList<String>(), solution.splitMessage("abc", 5))
    }
}
