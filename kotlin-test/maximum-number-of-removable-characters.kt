package maximumnumberofremovablecharacters

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumnumberofremovablecharactersTest {
    @Test
    fun example1() {
        assertEquals(2, Solution().maximumRemovals("abcacb", "ab", intArrayOf(3, 1, 0)))
    }

    @Test
    fun example2() {
        assertEquals(1, Solution().maximumRemovals("abcbddddd", "abcd", intArrayOf(3, 2, 1, 4, 5, 6)))
    }

    @Test
    fun example3() {
        assertEquals(0, Solution().maximumRemovals("abcab", "abc", intArrayOf(0, 1, 2, 3, 4)))
    }

    @Test
    fun cannotRemoveBothCharacters() {
        assertEquals(0, Solution().maximumRemovals("ab", "ab", intArrayOf(0, 1)))
    }
}
