package occurrencesafterbigram

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class OccurrencesAfterBigramTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertEquals(
            listOf("girl", "student"),
            solution.findOcurrences("alice is a good girl she is a good student", "a", "good")
        )
    }

    @Test
    fun testExample2() {
        assertEquals(
            listOf("we", "rock"),
            solution.findOcurrences("we will we will rock you", "we", "will")
        )
    }

    @Test
    fun testSingleOccurrence() {
        assertEquals(
            listOf("c"),
            solution.findOcurrences("a b c d e", "a", "b")
        )
    }

    @Test
    fun testOverlapping() {
        assertEquals(
            listOf("a", "a"),
            solution.findOcurrences("a a a a", "a", "a")
        )
    }
}
