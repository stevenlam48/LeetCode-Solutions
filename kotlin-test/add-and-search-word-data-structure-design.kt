package addandsearchworddatastructuredesign

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class PaddandsearchworddatastructuredesignTest {
    @Test
    fun example() {
        val wordDictionary = WordDictionary()
        wordDictionary.addWord("bad")
        wordDictionary.addWord("dad")
        wordDictionary.addWord("mad")
        assertFalse(wordDictionary.search("pad"))
        assertTrue(wordDictionary.search("bad"))
        assertTrue(wordDictionary.search(".ad"))
        assertTrue(wordDictionary.search("b.."))
    }

    @Test
    fun emptyDictionary() {
        val wordDictionary = WordDictionary()
        assertFalse(wordDictionary.search("a"))
        assertFalse(wordDictionary.search("."))
    }

    @Test
    fun exactMatchOnly() {
        val wordDictionary = WordDictionary()
        wordDictionary.addWord("hello")
        assertTrue(wordDictionary.search("hello"))
        assertFalse(wordDictionary.search("hell"))
        assertFalse(wordDictionary.search("helloo"))
    }

    @Test
    fun wildcards() {
        val wordDictionary = WordDictionary()
        wordDictionary.addWord("a")
        wordDictionary.addWord("ab")
        assertTrue(wordDictionary.search("a"))
        assertTrue(wordDictionary.search("."))
        assertTrue(wordDictionary.search(".."))
        assertFalse(wordDictionary.search("..."))
    }

    @Test
    fun prefixIsNotWord() {
        val wordDictionary = WordDictionary()
        wordDictionary.addWord("abc")
        assertFalse(wordDictionary.search("ab"))
        assertTrue(wordDictionary.search("a.c"))
    }
}
