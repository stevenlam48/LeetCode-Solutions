package implementtrieiiprefixtree

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ImplementTrieIiPrefixTreeTest {
    @Test
    fun example() {
        val trie = Trie()
        trie.insert("apple")
        trie.insert("apple")
        assertEquals(2, trie.countWordsEqualTo("apple"))
        assertEquals(2, trie.countWordsStartingWith("app"))
        trie.erase("apple")
        assertEquals(1, trie.countWordsEqualTo("apple"))
        assertEquals(1, trie.countWordsStartingWith("app"))
        trie.erase("apple")
        assertEquals(0, trie.countWordsEqualTo("apple"))
        assertEquals(0, trie.countWordsStartingWith("app"))
    }

    @Test
    fun sharedPrefixes() {
        val trie = Trie()
        trie.insert("app")
        trie.insert("apple")
        trie.insert("apply")
        assertEquals(3, trie.countWordsStartingWith("app"))
        assertEquals(1, trie.countWordsEqualTo("app"))
        trie.erase("app")
        assertEquals(0, trie.countWordsEqualTo("app"))
        assertEquals(2, trie.countWordsStartingWith("app"))
        assertEquals(1, trie.countWordsEqualTo("apple"))
    }

    @Test
    fun eraseMissingWord() {
        val trie = Trie()
        trie.insert("abc")
        trie.erase("abd")
        trie.erase("ab")
        assertEquals(1, trie.countWordsEqualTo("abc"))
        assertEquals(1, trie.countWordsStartingWith("ab"))
    }

    @Test
    fun emptyTrie() {
        val trie = Trie()
        assertEquals(0, trie.countWordsEqualTo("a"))
        assertEquals(0, trie.countWordsStartingWith("a"))
    }
}
