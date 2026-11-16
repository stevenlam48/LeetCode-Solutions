package groupsofstrings

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class GroupsOfStringsTest {
    @Test
    fun example1() {
        assertArrayEquals(intArrayOf(2, 3), Solution().groupStrings(listOf("a", "b", "ab", "cde")))
    }

    @Test
    fun example2() {
        assertArrayEquals(intArrayOf(1, 3), Solution().groupStrings(listOf("a", "ab", "abc")))
    }

    @Test
    fun disconnectedPairs() {
        assertArrayEquals(intArrayOf(2, 1), Solution().groupStrings(listOf("ab", "cd")))
    }

    @Test
    fun singleLetters() {
        assertArrayEquals(intArrayOf(1, 2), Solution().groupStrings(listOf("a", "b")))
    }

    @Test
    fun singleWord() {
        assertArrayEquals(intArrayOf(1, 1), Solution().groupStrings(listOf("a")))
    }
}
