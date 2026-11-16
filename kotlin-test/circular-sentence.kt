package circularsentence

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class CircularSentenceTest {
    @Test
    fun circularSentenceExample() {
        assertTrue(Solution().isCircularSentence("leetcode exercises sound delightful"))
    }

    @Test
    fun adjacentWordsHaveDifferentBoundaryLetters() {
        assertFalse(Solution().isCircularSentence("Leetcode is cool"))
    }

    @Test
    fun firstAndLastWordsDoNotMatch() {
        assertFalse(Solution().isCircularSentence("ab cd"))
    }

    @Test
    fun singleCircularWord() {
        assertTrue(Solution().isCircularSentence("level"))
    }
}
