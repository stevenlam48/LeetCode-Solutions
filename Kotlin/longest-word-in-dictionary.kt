package longestwordindictionary

// Time:  O(n), n is the total sum of the lengths of words
// Space: O(t), t is the number of nodes in trie

class Solution {
    fun longestWord(words: Array<String>): String {
        val trie = TrieNode()
        for (i in words.indices) {
            trie.insert(words[i], i)
        }

        // DFS
        val stk = ArrayDeque<TrieNode>()
        for (node in trie.leaves) {
            if (node != null) {
                stk.addLast(node)
            }
        }

        var result = ""
        while (stk.isNotEmpty()) {
            val curr = stk.removeLast()
            if (curr.isString) {
                val word = words[curr.value]
                if (word.length > result.length ||
                    (word.length == result.length && word < result)
                ) {
                    result = word
                }
                for (node in curr.leaves) {
                    if (node != null) {
                        stk.addLast(node)
                    }
                }
            }
        }
        return result
    }

    private class TrieNode {
        var isString = false
        var value = 0
        val leaves = arrayOfNulls<TrieNode>(26)

        fun insert(s: String, i: Int) {
            var p = this
            for (c in s) {
                if (p.leaves[c - 'a'] == null) {
                    p.leaves[c - 'a'] = TrieNode()
                }
                p = p.leaves[c - 'a']!!
            }
            p.isString = true
            p.value = i
        }
    }
}
