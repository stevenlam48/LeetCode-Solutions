package implementtrieiiprefixtree

// Time:  ctor:         O(1)
//        insert:       O(n)
//        count_word:   O(n)
//        count_prefix: O(n)
//        erase:        O(n)
// Space: O(t), t is the number of nodes in trie

private class TrieNode {
    val children = arrayOfNulls<TrieNode>(26)
    var pcnt = 0
    var cnt = 0
}

class Trie {
    private val trie_ = TrieNode()

    fun insert(word: String) {
        var curr = trie_
        ++curr.pcnt
        for (c in word) {
            val idx = c - 'a'
            if (curr.children[idx] == null) {
                curr.children[idx] = TrieNode()
            }
            curr = curr.children[idx]!!
            ++curr.pcnt
        }
        ++curr.cnt
    }

    fun countWordsEqualTo(word: String): Int {
        var curr = trie_
        for (c in word) {
            val idx = c - 'a'
            if (curr.children[idx] == null) {
                return 0
            }
            curr = curr.children[idx]!!
        }
        return curr.cnt
    }

    fun countWordsStartingWith(prefix: String): Int {
        var curr = trie_
        for (c in prefix) {
            val idx = c - 'a'
            if (curr.children[idx] == null) {
                return 0
            }
            curr = curr.children[idx]!!
        }
        return curr.pcnt
    }

    fun erase(word: String) {
        val cnt = countWordsEqualTo(word)
        if (cnt == 0) {
            return
        }
        var curr = trie_
        --curr.pcnt
        for (c in word) {
            val idx = c - 'a'
            if (curr.children[idx]!!.pcnt == 1) {
                curr.children[idx] = null  // delete all unused nodes
                return
            }
            curr = curr.children[idx]!!
            --curr.pcnt
        }
        --curr.cnt
    }
}
