package boldwordsinstring

// Time:  O(n * l), n is the length of S, l is the average length of words
// Space: O(t)    , t is the size of trie

class Solution {
    fun boldWords(words: List<String>, S: String): String {
        val trie = TrieNode()
        for (word in words) {
            trie.insert(word)
        }

        val lookup = BooleanArray(S.length)
        for (i in S.indices) {
            var curr: TrieNode? = trie
            var k = i - 1
            for (j in i until S.length) {
                curr = curr!!.leaves[S[j] - 'a']
                if (curr == null) {
                    break
                }
                if (curr.isString) {
                    k = j
                }
            }
            for (t in i..k) {
                lookup[t] = true
            }
        }

        val result = StringBuilder()
        for (i in S.indices) {
            if (lookup[i] && (i == 0 || !lookup[i - 1])) {
                result.append("<b>")
            }
            result.append(S[i])
            if (lookup[i] && (i == S.length - 1 || !lookup[i + 1])) {
                result.append("</b>")
            }
        }
        return result.toString()
    }

    private class TrieNode {
        var isString = false
        val leaves = arrayOfNulls<TrieNode>(26)

        fun insert(s: String) {
            var p = this
            for (c in s) {
                if (p.leaves[c - 'a'] == null) {
                    p.leaves[c - 'a'] = TrieNode()
                }
                p = p.leaves[c - 'a']!!
            }
            p.isString = true
        }
    }
}
