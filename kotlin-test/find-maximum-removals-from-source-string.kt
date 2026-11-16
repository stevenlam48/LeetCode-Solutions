package findmaximumremovalsfromsourcestring

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FindMaximumRemovalsFromSourceStringTest {
    @Test
    fun example1() {
        assertEquals(1, Solution().maxRemovals("abbaa", "aba", intArrayOf(0, 1, 2)))
    }

    @Test
    fun example2() {
        assertEquals(2, Solution().maxRemovals("bcda", "d", intArrayOf(0, 3)))
    }

    @Test
    fun example3() {
        assertEquals(0, Solution().maxRemovals("dda", "dda", intArrayOf(0, 1, 2)))
    }

    @Test
    fun noTargetIndices() {
        assertEquals(0, Solution().maxRemovals("abc", "abc", intArrayOf()))
    }

    @Test
    fun removeUnusedCharacter() {
        assertEquals(1, Solution().maxRemovals("abc", "ac", intArrayOf(1)))
    }

    @Test
    fun cannotRemovePatternCharacters() {
        assertEquals(0, Solution().maxRemovals("ab", "ab", intArrayOf(0, 1)))
    }
}
