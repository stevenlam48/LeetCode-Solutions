package sortvowelsinastring

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class SortVowelsInAStringTest {
    @Test
    fun standardMixedCaseExample() {
        assertEquals("lEOtcede", Solution().sortVowels("lEetcOde"))
    }

    @Test
    fun uppercaseVowelsSortBeforeLowercase() {
        assertEquals("OUaei", Solution().sortVowels("aeiOU"))
    }

    @Test
    fun consonantsRetainTheirPositions() {
        assertEquals("bAcAdEfI", Solution().sortVowels("bIcEdAfA"))
    }

    @Test
    fun duplicateVowels() {
        assertEquals("AAeeoo", Solution().sortVowels("ooeeAA"))
    }

    @Test
    fun emptyAndNoVowels() {
        assertEquals("", Solution().sortVowels(""))
        assertEquals("bcd xyz", Solution().sortVowels("bcd xyz"))
    }
}
