package longestwordwithallprefixes

// Time:  O(n)
// Space: O(t), t is the number of nodes in trie

class Solution {
    private class TrieNode {
        var idx = -1
        val leaves = HashMap<Char, TrieNode>()

        fun insert(i: Int, s: String) {
            var p = this
            for (c in s) {
                if (!p.leaves.containsKey(c)) {
                    p.leaves[c] = TrieNode()
                }
                p = p.leaves[c]!!
            }
            p.idx = i
        }
    }

    fun longestWord(words: Array<String>): String {
        val trie = TrieNode()
        for (i in words.indices) {
            trie.insert(i, words[i])
        }
        return iterDfs(words, trie)
    }

    private fun iterDfs(words: Array<String>, node: TrieNode): String {
        var result = -1
        val stk = ArrayDeque<TrieNode>()
        stk.addLast(node)
        while (stk.isNotEmpty()) {
            val curr = stk.removeLast()
            if (result == -1 || words[curr.idx].length > words[result].length) {
                result = curr.idx
            }
            var c = 'z'
            while (c >= 'a') {
                val child = curr.leaves[c]
                if (child != null && child.idx != -1) {
                    stk.addLast(child)
                }
                --c
            }
        }
        return if (result != -1) words[result] else ""
    }
}
