package decrementalstringconcatenation

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class DecrementalStringConcatenationTest {
    private val solution = Solution()

    @Test
    fun joinsBothEndsOfMiddleWord() {
        assertEquals(4, solution.minimizeConcatenatedLength(arrayOf("aa", "ab", "bc")))
    }

    @Test
    fun joinsSingleCharacterWord() {
        assertEquals(2, solution.minimizeConcatenatedLength(arrayOf("ab", "b")))
    }

    @Test
    fun joinsRepeatedCharacters() {
        assertEquals(6, solution.minimizeConcatenatedLength(arrayOf("aaa", "c", "aba")))
    }

    @Test
    fun singleWordHasOriginalLength() {
        assertEquals(5, solution.minimizeConcatenatedLength(arrayOf("abcde")))
    }

    @Test
    fun noMatchingEndpoints() {
        assertEquals(6, solution.minimizeConcatenatedLength(arrayOf("ab", "cd", "ef")))
    }
}
