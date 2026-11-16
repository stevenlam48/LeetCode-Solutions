package findklengthsubstringswithnorepeatedcharacters

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FindKLengthSubstringsWithNoRepeatedCharactersTest {
    @Test
    fun countsAllUniqueWindows() {
        assertEquals(6, Solution().numKLenSubstrNoRepeats("havefunonleetcode", 5))
    }

    @Test
    fun excludesWindowsContainingDuplicates() {
        assertEquals(0, Solution().numKLenSubstrNoRepeats("home", 5))
        assertEquals(0, Solution().numKLenSubstrNoRepeats("aaaa", 2))
    }

    @Test
    fun handlesLengthOneAndSingleCharacterInput() {
        assertEquals(4, Solution().numKLenSubstrNoRepeats("abba", 1))
        assertEquals(1, Solution().numKLenSubstrNoRepeats("a", 1))
    }

    @Test
    fun handlesEmptyInput() {
        assertEquals(0, Solution().numKLenSubstrNoRepeats("", 3))
    }
}
