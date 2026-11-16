package implementtrieprefixtree

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class ImplementTriePrefixTreeTest {
    @Test
    fun example() {
        val trie = Trie()
        trie.insert("apple")
        assertTrue(trie.search("apple"))
        assertFalse(trie.search("app"))
        assertTrue(trie.startsWith("app"))
        trie.insert("app")
        assertTrue(trie.search("app"))
    }

    @Test
    fun emptyPrefix() {
        val trie = Trie()
        trie.insert("abc")
        assertTrue(trie.startsWith(""))
        assertFalse(trie.search(""))
    }

    @Test
    fun missingWords() {
        val trie = Trie()
        trie.insert("hello")
        assertFalse(trie.search("hell"))
        assertFalse(trie.search("helloo"))
        assertFalse(trie.startsWith("x"))
    }

    @Test
    fun multipleWords() {
        val trie = Trie()
        trie.insert("a")
        trie.insert("ab")
        trie.insert("abc")
        assertTrue(trie.search("a"))
        assertTrue(trie.search("ab"))
        assertTrue(trie.search("abc"))
        assertTrue(trie.startsWith("ab"))
    }
}
