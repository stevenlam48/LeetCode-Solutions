package prefixandsuffixsearch

// Time:  ctor:   O(w * l^2), w is the number of words, l is the word length on average
//        search: O(p + s)  , p is the length of the prefix, s is the length of the suffix,
// Space: O(t), t is the number of trie nodes

class WordFilter(words: List<String>) {
    private class TrieNode {
        var weight = 0
        val leaves = arrayOfNulls<TrieNode>(27)
    }

    private val trie = TrieNode()
    private val separator = "{"

    init {
        for (i in words.indices) {
            for (j in 0..words[i].length) {
                insert(words[i].substring(j) + separator + words[i], i)
            }
        }
    }

    private fun insert(s: String, weight: Int) {
        var p = trie
        p.weight = weight
        for (c in s) {
            val index = c - 'a'
            if (p.leaves[index] == null) {
                p.leaves[index] = TrieNode()
            }
            p = p.leaves[index]!!
            p.weight = weight
        }
    }

    fun f(prefix: String, suffix: String): Int {
        var p: TrieNode? = trie
        for (c in suffix + separator + prefix) {
            p = p?.leaves[c - 'a'] ?: return -1
        }
        return p!!.weight
    }
}
