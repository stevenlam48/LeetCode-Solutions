package shortencodingofwords

// Time:  O(n), n is the total sum of the lengths of words
// Space: O(t), t is the number of nodes in trie

class Solution {
    fun minimumLengthEncoding(words: Array<String>): Int {
        val uniqueWords = words.toSet()
        val leaves = mutableListOf<TrieNode>()
        val trie = TrieNode()
        for (word in uniqueWords) {
            leaves.add(trie.insert(word.reversed()))
        }
        var result = 0
        var i = 0
        for (word in uniqueWords) {
            if (leaves[i++].leaves.isEmpty()) {
                result += word.length + 1
            }
        }
        return result
    }

    private class TrieNode {
        val leaves = HashMap<Int, TrieNode>()

        fun insert(s: String): TrieNode {
            var node = this
            for (c in s) {
                val index = c - 'a'
                if (node.leaves[index] == null) {
                    node.leaves[index] = TrieNode()
                }
                node = node.leaves[index]!!
            }
            return node
        }
    }
}
