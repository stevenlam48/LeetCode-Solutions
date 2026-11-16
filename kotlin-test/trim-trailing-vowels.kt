package trimtrailingvowels

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class TrimTrailingVowelsTest {
    @Test
    fun trimsOneOrManyTrailingVowels() {
        assertEquals("leetcod", Solution().trimTrailingVowels("leetcodeui"))
        assertEquals("b", Solution().trimTrailingVowels("baeiou"))
    }

    @Test
    fun preservesInternalAndUppercaseVowels() {
        assertEquals("ideas are fin", Solution().trimTrailingVowels("ideas are fineu"))
        assertEquals("AEIOU", Solution().trimTrailingVowels("AEIOU"))
    }

    @Test
    fun emptyAndAllVowels() {
        assertEquals("", Solution().trimTrailingVowels(""))
        assertEquals("", Solution().trimTrailingVowels("aeiou"))
        assertEquals("xyz", Solution().trimTrailingVowels("xyz"))
    }
}
