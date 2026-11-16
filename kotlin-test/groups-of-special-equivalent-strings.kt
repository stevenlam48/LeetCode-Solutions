package groupsofspecialequivalentstrings

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class GroupsOfSpecialEquivalentStringsTest {
    @Test
    fun example1() {
        val A = listOf("abcd", "cdab", "cbad", "xyzz", "zzxy", "zzyx")
        assertEquals(3, Solution().numSpecialEquivGroups(A))
    }

    @Test
    fun example2() {
        val A = listOf("abc", "acb", "bac", "bca", "cab", "cba")
        assertEquals(3, Solution().numSpecialEquivGroups(A))
    }

    @Test
    fun singleEmptyString() {
        assertEquals(1, Solution().numSpecialEquivGroups(listOf("")))
    }

    @Test
    fun singleCharacter() {
        assertEquals(1, Solution().numSpecialEquivGroups(listOf("a")))
    }

    @Test
    fun differentLengths() {
        assertEquals(2, Solution().numSpecialEquivGroups(listOf("ab", "abc")))
    }
}
