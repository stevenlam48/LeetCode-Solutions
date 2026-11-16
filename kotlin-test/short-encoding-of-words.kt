package shortencodingofwords

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class ShortEncodingOfWordsTest {
    @Test
    fun omitsWordsThatAreSuffixes() {
        assertEquals(10, Solution().minimumLengthEncoding(arrayOf("time", "me", "bell")))
    }

    @Test
    fun handlesOneWordAndDuplicates() {
        assertEquals(2, Solution().minimumLengthEncoding(arrayOf("t")))
        assertEquals(5, Solution().minimumLengthEncoding(arrayOf("time", "time", "me")))
    }

    @Test
    fun handlesSharedSuffixTrieBranches() {
        assertEquals(11, Solution().minimumLengthEncoding(arrayOf("me", "time", "atime", "bell")))
    }

    @Test
    fun handlesEmptyInput() {
        assertEquals(0, Solution().minimumLengthEncoding(emptyArray()))
    }
}
