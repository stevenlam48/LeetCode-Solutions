package checkifstringisdecomposableintovalueequalsubstrings

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class CheckIfStringIsDecomposableIntoValueEqualSubstringsTest {
    private val solution = Solution()

    @Test
    fun fiveEqualDigitsCanBeTripleAndPair() {
        assertTrue(solution.isDecomposable("00011111222"))
    }

    @Test
    fun invalidTotalLength() {
        assertFalse(solution.isDecomposable("011122"))
    }

    @Test
    fun nondecomposableEqualLengthPairs() {
        assertFalse(solution.isDecomposable("003366"))
    }

    @Test
    fun singlePair() {
        assertTrue(solution.isDecomposable("aa"))
    }

    @Test
    fun twoDoubleLengthSubstrings() {
        assertFalse(solution.isDecomposable("aaabbaa"))
    }

    @Test
    fun triplesAndOneFinalPair() {
        assertTrue(solution.isDecomposable("aaabbbcc"))
    }
}
