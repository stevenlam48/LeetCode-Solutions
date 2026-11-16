package maximumdeletionsonastring

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class MaximumDeletionsOnAStringTest {
    private val solution = Solution()

    @Test
    fun repeatedPrefixAllowsTwoDeletions() {
        assertEquals(2, solution.deleteString("abcabcdabc"))
    }

    @Test
    fun differentDeletionLengths() {
        assertEquals(4, solution.deleteString("aaabaab"))
    }

    @Test
    fun allCharactersEqual() {
        assertEquals(5, solution.deleteString("aaaaa"))
    }

    @Test
    fun singleCharacter() {
        assertEquals(1, solution.deleteString("z"))
    }
}
