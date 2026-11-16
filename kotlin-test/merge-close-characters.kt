package mergeclosecharacters

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MergeCloseCharactersTest {
    @Test
    fun closeOccurrencesAreSkipped() {
        assertEquals("abca", Solution().mergeCharacters("abaca", 2))
        assertEquals("abc", Solution().mergeCharacters("abca", 3))
    }

    @Test
    fun occurrenceBeyondDistanceIsKept() {
        assertEquals("abaca", Solution().mergeCharacters("abaca", 1))
    }

    @Test
    fun consecutiveCharacters() {
        assertEquals("a", Solution().mergeCharacters("aaaa", 1))
        assertEquals("abc", Solution().mergeCharacters("aabbcc", 1))
    }

    @Test
    fun emptyInput() {
        assertEquals("", Solution().mergeCharacters("", 2))
    }
}
