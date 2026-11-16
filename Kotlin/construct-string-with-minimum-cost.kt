package constructstringwithminimumcost

// Time:  O(n^2 + w * l)
// Space: O(t)

private const val INF = Int.MAX_VALUE

// trie, dp
class Solution {
    private class Trie {
        private val nodes = mutableListOf<IntArray>()
        private val mns = mutableListOf<Int>()

        init {
            newNode()
        }

        fun add(w: String, c: Int) {
            var curr = 0
            for (ch in w) {
                val x = ch - 'a'
                if (nodes[curr][x] == -1) {
                    nodes[curr][x] = newNode()
                }
                curr = nodes[curr][x]
            }
            mns[curr] = minOf(mns[curr], c)
        }

        fun query(i: Int, t: String, dp: IntArray) {
            var curr = 0
            for (j in i until t.length) {
                val x = t[j] - 'a'
                if (nodes[curr][x] == -1) {
                    break
                }
                curr = nodes[curr][x]
                if (mns[curr] != INF) {
                    dp[j + 1] = minOf(dp[j + 1], dp[i] + mns[curr])
                }
            }
        }

        private fun newNode(): Int {
            nodes.add(IntArray(26) { -1 })
            mns.add(INF)
            return nodes.size - 1
        }
    }

    fun minimumCost(target: String, words: List<String>, costs: IntArray): Int {
        val trie = Trie()
        for (i in words.indices) {
            trie.add(words[i], costs[i])
        }
        val dp = IntArray(target.length + 1) { INF }
        dp[0] = 0
        for (i in target.indices) {
            if (dp[i] == INF) {
                continue
            }
            trie.query(i, target, dp)
        }
        return if (dp.last() != INF) dp.last() else -1
    }
}
