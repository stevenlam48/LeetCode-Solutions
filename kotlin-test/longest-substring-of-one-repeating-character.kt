package longestsubstringofonerepeatingcharacter

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class LongestSubstringOfOneRepeatingCharacterTest {
    @Test
    fun standardExample() {
        assertArrayEquals(
            intArrayOf(3, 3, 3),
            Solution().longestRepeating("babacc", "bcb", intArrayOf(1, 3, 4))
        )
    }

    @Test
    fun anotherStandardExample() {
        assertArrayEquals(intArrayOf(2, 3), Solution().longestRepeating("abyzz", "aa", intArrayOf(2, 1)))
    }

    @Test
    fun singleCharacterUpdates() {
        assertArrayEquals(intArrayOf(1, 1), Solution().longestRepeating("a", "ba", intArrayOf(0, 0)))
    }

    @Test
    fun updatesMergeRunsAcrossBothChildren() {
        assertArrayEquals(intArrayOf(3, 4), Solution().longestRepeating("abab", "aa", intArrayOf(1, 3)))
    }
}
