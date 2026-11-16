package shortestcompletingword

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class ShortestCompletingWordTest {
    @Test
    fun choosesShortestCompletingWord() {
        val words = arrayOf("step", "steps", "stripe", "sple")
        assertEquals("steps", Solution().shortestCompletingWord("1s3 PSt", words))
    }

    @Test
    fun ignoresDigitsSpacesAndCase() {
        val words = arrayOf("looks", "pest", "stew", "show")
        assertEquals("pest", Solution().shortestCompletingWord("1s3 456", words))
    }

    @Test
    fun requiresRepeatedLettersAndPreservesFirstTie() {
        assertEquals("pp", Solution().shortestCompletingWord("Pp", arrayOf("pt", "ppt", "pp")))
        assertEquals("prop", Solution().shortestCompletingWord("pp", arrayOf("prop", "pope")))
    }
}
