package findthelongestsubstringcontainingvowelsinevencounts

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FindTheLongestSubstringContainingVowelsInEvenCountsTest {
    @Test
    fun exampleOne() {
        assertEquals(13, Solution().findTheLongestSubstring("eleetminicoworoep"))
    }

    @Test
    fun exampleTwo() {
        assertEquals(5, Solution().findTheLongestSubstring("leetcodeisgreat"))
    }

    @Test
    fun consonantsOnly() {
        assertEquals(6, Solution().findTheLongestSubstring("bcbcbc"))
    }

    @Test
    fun evenVowelPairs() {
        assertEquals(4, Solution().findTheLongestSubstring("aeae"))
    }

    @Test
    fun emptyString() {
        assertEquals(0, Solution().findTheLongestSubstring(""))
    }
}
