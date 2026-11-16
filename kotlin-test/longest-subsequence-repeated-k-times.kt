package longestsubsequencerepeatedktimes

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class LongestSubsequenceRepeatedKTimesTest {
    @Test
    fun standardExample() {
        assertEquals("let", Solution().longestSubsequenceRepeatedK("letsleetcode", 2))
    }

    @Test
    fun twoCopiesOfOneCharacter() {
        assertEquals("b", Solution().longestSubsequenceRepeatedK("bb", 2))
    }

    @Test
    fun noCharacterOccursEnoughTimes() {
        assertEquals("", Solution().longestSubsequenceRepeatedK("ab", 2))
    }

    @Test
    fun equalLengthResultUsesLargestCharacter() {
        assertEquals("b", Solution().longestSubsequenceRepeatedK("abcba", 2))
    }
}
