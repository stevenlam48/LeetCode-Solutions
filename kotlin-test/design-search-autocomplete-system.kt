package designsearchautocompletesystem

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class DesignSearchAutocompleteSystemTest {
    @Test
    fun testExample() {
        val system = AutocompleteSystem(
            listOf("i love you", "island", "iroman", "i love leetcode"),
            intArrayOf(5, 3, 2, 2)
        )
        assertEquals(listOf("i love you", "island", "i love leetcode"), system.input('i'))
        assertEquals(listOf("i love you", "i love leetcode"), system.input(' '))
        assertEquals(emptyList<String>(), system.input('a'))
        assertEquals(emptyList<String>(), system.input('#'))
        assertEquals(listOf("i love you", "island", "i love leetcode"), system.input('i'))
    }

    @Test
    fun testNewSentenceIsAdded() {
        val system = AutocompleteSystem(listOf("abc"), intArrayOf(1))
        assertEquals(listOf("abc"), system.input('a'))
        assertEquals(listOf("abc"), system.input('b'))
        assertEquals(listOf("abc"), system.input('c'))
        assertEquals(emptyList<String>(), system.input('#'))
        assertEquals(listOf("abc"), system.input('a'))
    }

    @Test
    fun testTieBreakLexicographic() {
        val system = AutocompleteSystem(listOf("ab", "aa", "ac"), intArrayOf(1, 1, 1))
        assertEquals(listOf("aa", "ab", "ac"), system.input('a'))
    }

    @Test
    fun testOnlyTopThreeAndCounterUpdate() {
        val system = AutocompleteSystem(
            listOf("a", "ab", "abc", "abcd"),
            intArrayOf(4, 3, 2, 1)
        )
        assertEquals(listOf("a", "ab", "abc"), system.input('a'))
        val system2 = AutocompleteSystem(listOf("x", "xy"), intArrayOf(1, 1))
        assertEquals(listOf("x", "xy"), system2.input('x'))
        assertEquals(emptyList<String>(), system2.input('#'))
        assertEquals(listOf("x", "xy"), system2.input('x'))
    }

    @Test
    fun testPrefixWithoutMatches() {
        val system = AutocompleteSystem(listOf("hello"), intArrayOf(1))
        assertEquals(listOf("hello"), system.input('h'))
        assertEquals(emptyList<String>(), system.input('z'))
        assertEquals(emptyList<String>(), system.input('z'))
    }
}
