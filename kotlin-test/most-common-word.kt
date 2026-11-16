package mostcommonword

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MostCommonWordTest {
    private val solution = Solution()

    @Test
    fun ignoresBannedWordAndPunctuation() {
        assertEquals(
            "ball",
            solution.mostCommonWord("Bob hit a ball, the hit BALL flew far after it was hit.", arrayOf("hit"))
        )
    }

    @Test
    fun selectsNextMostFrequentWord() {
        assertEquals("b", solution.mostCommonWord("a, a, a, a, b,b,b,c, c", arrayOf("a")))
    }

    @Test
    fun handlesCapitalizationAndFinalWord() {
        assertEquals("ball", solution.mostCommonWord("Bob. hIt, baLl", arrayOf("bob", "hit")))
    }

    @Test
    fun returnsEmptyForEmptyOrFullyBannedInput() {
        assertEquals("", solution.mostCommonWord("", arrayOf()))
        assertEquals("", solution.mostCommonWord("only only", arrayOf("only")))
    }
}
