package findandreplacepattern

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class FindAndReplacePatternTest {
    @Test
    fun standardExample() {
        assertEquals(
            listOf("mee", "aqq"),
            Solution().findAndReplacePattern(listOf("abc", "deq", "mee", "aqq", "dkd", "ccc"), "abb")
        )
    }

    @Test
    fun repeatedPatternCharacters() {
        assertEquals(
            listOf("xxx", "yyy"),
            Solution().findAndReplacePattern(listOf("xxx", "xyx", "yyy", "xyz"), "aaa")
        )
    }

    @Test
    fun noMatches() {
        assertEquals(emptyList<String>(), Solution().findAndReplacePattern(listOf("aa", "bb"), "ab"))
    }
}
