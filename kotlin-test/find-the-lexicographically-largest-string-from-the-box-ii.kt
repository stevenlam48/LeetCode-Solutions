package findthelexicographicallylargeststringfromtheboxii

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FindTheLexicographicallyLargestStringFromTheBoxIITest {
    @Test
    fun example() {
        assertEquals("dbc", Solution().answerString("dbca", 2))
    }

    @Test
    fun everyFriendGetsOneCharacter() {
        assertEquals("g", Solution().answerString("gggg", 4))
    }

    @Test
    fun oneFriend() {
        assertEquals("leetcode", Solution().answerString("leetcode", 1))
    }

    @Test
    fun suffixCanBeAnswer() {
        assertEquals("z", Solution().answerString("aaaz", 4))
    }

    @Test
    fun repeatedCandidates() {
        assertEquals("bab", Solution().answerString("aabab", 3))
    }
}
