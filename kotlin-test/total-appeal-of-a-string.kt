package totalappealofastring

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class TotalAppealOfAStringTest {
    @Test
    fun exampleAbbca() {
        assertEquals(28L, Solution().appealSum("abbca"))
    }

    @Test
    fun exampleCode() {
        assertEquals(20L, Solution().appealSum("code"))
    }

    @Test
    fun singleCharacter() {
        assertEquals(1L, Solution().appealSum("a"))
    }

    @Test
    fun emptyString() {
        assertEquals(0L, Solution().appealSum(""))
    }

    @Test
    fun allSameCharacter() {
        assertEquals(6L, Solution().appealSum("aaa"))
    }
}
