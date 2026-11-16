package extracharactersinastring

// Time:  O((n + m) * l), l is max(len(w) for w in dictionary)
// Space: O(n + t)

class Solution {
    fun minExtraChar(s: String, dictionary: List<String>): Int {
        val trie = Trie()
        for (word in dictionary) {
            trie.insert(word)
        }
        val dp = IntArray(s.length + 1) { Int.MAX_VALUE }
        dp[0] = 0
        for (i in s.indices) {
            dp[i + 1] = minOf(dp[i + 1], dp[i] + 1)
            var curr = 0
            for (j in i until s.length) {
                curr = trie.child(curr, s[j])
                if (curr == 0) {
                    break
                }
                if (trie.isString(curr)) {
                    dp[j + 1] = minOf(dp[j + 1], dp[i])
                }
            }
        }
        return dp.last()
    }

    private class Trie {
        private val nodes = mutableListOf<IntArray>()

        init {
            createNode()
        }

        fun insert(s: String) {
            var curr = 0
            for (c in s) {
                if (nodes[curr][c - 'a'] == 0) {
                    nodes[curr][c - 'a'] = createNode()
                }
                curr = nodes[curr][c - 'a']
            }
            ++nodes[curr][26]
        }

        fun child(curr: Int, c: Char): Int {
            return nodes[curr][c - 'a']
        }

        fun isString(curr: Int): Boolean {
            return nodes[curr][26] != 0
        }

        private fun createNode(): Int {
            nodes.add(IntArray(26 + 1))
            return nodes.size - 1
        }
    }
}
