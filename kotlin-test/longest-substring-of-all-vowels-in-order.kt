package longestsubstringofallvowelsinorder

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class LongestSubstringOfAllVowelsInOrderTest {
    @Test
    fun exactlyOneOfEachVowel() {
        assertEquals(5, Solution().longestBeautifulSubstring("aeiou"))
    }

    @Test
    fun repeatedVowelsExtendTheSubstring() {
        assertEquals(11, Solution().longestBeautifulSubstring("aaeeiioouuu"))
    }

    @Test
    fun descentStartsANewCandidate() {
        assertEquals(5, Solution().longestBeautifulSubstring("aeiouaeiou"))
    }

    @Test
    fun nonVowelsAndMissingGroupsReturnZero() {
        assertEquals(0, Solution().longestBeautifulSubstring("aaiiiioou"))
    }
}
