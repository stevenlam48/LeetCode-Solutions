package replacewords

// Time:  O(n)
// Space: O(t), t is the number of nodes in trie

class Solution {
    fun replaceWords(dict: List<String>, sentence: String): String {
        val trie = TrieNode()
        val result = StringBuilder()
        for (s in dict) {
            trie.insert(s)
        }
        var curr: TrieNode? = trie
        for (c in sentence) {
            if (c == ' ' || curr == null || !curr.isString) {
                result.append(c)
            }
            if (c == ' ') {
                curr = trie
            } else if (curr != null && !curr.isString) {
                curr = curr.leaves[c]
            }
        }
        return result.toString()
    }

    private class TrieNode {
        var isString = false
        val leaves = HashMap<Char, TrieNode>()

        fun insert(s: String) {
            var p = this
            for (c in s) {
                p = p.leaves.getOrPut(c) { TrieNode() }
            }
            p.isString = true
        }
    }
}
