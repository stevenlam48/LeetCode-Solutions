package implementmagicdictionary

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class ImplementMagicDictionaryTest {
    @Test
    fun example() {
        val d = MagicDictionary()
        d.buildDict(listOf("hello", "leetcode"))
        assertFalse(d.search("hello"))
        assertTrue(d.search("hhllo"))
        assertFalse(d.search("hell"))
        assertFalse(d.search("leetcoded"))
    }

    @Test
    fun singleCharacterWords() {
        val d = MagicDictionary()
        d.buildDict(listOf("a", "b"))
        assertTrue(d.search("c"))
        assertTrue(d.search("a"))
        assertFalse(d.search("ab"))
    }

    @Test
    fun duplicateWords() {
        val d = MagicDictionary()
        d.buildDict(listOf("hello", "hello"))
        assertFalse(d.search("hello"))
        assertTrue(d.search("hellp"))
    }

    @Test
    fun emptyDictionary() {
        val d = MagicDictionary()
        d.buildDict(emptyList())
        assertFalse(d.search("a"))
        assertFalse(d.search(""))
    }
}
