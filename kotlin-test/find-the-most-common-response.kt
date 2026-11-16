package findthemostcommonresponse

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FindTheMostCommonResponseTest {
    @Test
    fun example1() {
        val responses = listOf(
            listOf("good", "ok", "good", "ok"),
            listOf("ok", "bad", "good", "ok", "ok"),
            listOf("good"),
            listOf("bad")
        )
        assertEquals("good", Solution().findCommonResponse(responses))
    }

    @Test
    fun example2() {
        val responses = listOf(
            listOf("good", "ok", "good"),
            listOf("ok", "bad"),
            listOf("bad", "good"),
            listOf("good")
        )
        assertEquals("good", Solution().findCommonResponse(responses))
    }

    @Test
    fun tieBreaksLexicographically() {
        val responses = listOf(listOf("b", "a"))
        assertEquals("a", Solution().findCommonResponse(responses))
    }
}
