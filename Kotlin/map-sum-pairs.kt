package mapsumpairs

// Time:  O(n), n is the length of key
// Space: O(t), t is the number of nodes in trie

class MapSum {
    private class TrieNode {
        var isString = false
        var count = 0
        var value = 0
        val leaves = HashMap<Char, TrieNode>()

        fun insert(s: String, value: Int) {
            val delta = value - getVal(s)
            var p = this
            for (c in s) {
                p = p.leaves.getOrPut(c) { TrieNode() }
                p.count += delta
            }
            p.value = value
            p.isString = true
        }

        fun getVal(s: String): Int {
            var p = this
            for (c in s) {
                p = p.leaves[c] ?: return 0
            }
            return if (p.isString) p.value else 0
        }

        fun getCount(s: String): Int {
            var p = this
            for (c in s) {
                p = p.leaves[c] ?: return 0
            }
            return p.count
        }
    }

    private val trie = TrieNode()

    fun insert(key: String, value: Int) {
        trie.insert(key, value)
    }

    fun sum(prefix: String): Int {
        return trie.getCount(prefix)
    }
}
