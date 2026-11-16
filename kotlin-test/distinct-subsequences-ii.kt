package distinctsubsequencesii

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class DistinctSubsequencesIiTest {
    private val solution = Solution()

    @Test
    fun allDistinctCharacters() {
        assertEquals(7, solution.distinctSubseqII("abc"))
    }

    @Test
    fun repeatedCharacter() {
        assertEquals(3, solution.distinctSubseqII("aaa"))
    }

    @Test
    fun overlappingSubsequences() {
        assertEquals(6, solution.distinctSubseqII("aba"))
    }

    @Test
    fun emptyString() {
        assertEquals(0, solution.distinctSubseqII(""))
    }
}
