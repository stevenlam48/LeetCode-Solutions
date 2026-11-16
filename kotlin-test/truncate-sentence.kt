package truncatesentence

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class TruncateSentenceTest {
    @Test
    fun standardExamples() {
        assertEquals("Hello how are you", Solution().truncateSentence("Hello how are you Contestant", 4))
        assertEquals("What is the solution", Solution().truncateSentence("What is the solution to this problem", 4))
        assertEquals("chopper is not a tanuki", Solution().truncateSentence("chopper is not a tanuki", 5))
    }

    @Test
    fun oneWord() {
        assertEquals("Hello", Solution().truncateSentence("Hello brave new world", 1))
        assertEquals("single", Solution().truncateSentence("single", 1))
    }

    @Test
    fun emptyInput() {
        assertEquals("", Solution().truncateSentence("", 1))
    }
}
