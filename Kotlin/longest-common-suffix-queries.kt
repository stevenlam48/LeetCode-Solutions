package longestcommonsuffixqueries

// Time:  O((n + q) * l)
// Space: O(t)

class Solution {
    private class Trie {
        private val nodes = mutableListOf<IntArray>()
        private val mns = mutableListOf<Pair<Int, Int>>()

        init {
            newNode()
        }

        fun add(i: Int, w: String) {
            var curr = 0
            updateMin(curr, w.length, i)
            for (j in w.length - 1 downTo 0) {
                val x = w[j] - 'a'
                if (nodes[curr][x] == -1) {
                    nodes[curr][x] = newNode()
                }
                curr = nodes[curr][x]
                updateMin(curr, w.length, i)
            }
        }

        fun query(w: String): Int {
            var curr = 0
            for (j in w.length - 1 downTo 0) {
                val x = w[j] - 'a'
                if (nodes[curr][x] == -1) {
                    break
                }
                curr = nodes[curr][x]
            }
            return mns[curr].second
        }

        private fun updateMin(curr: Int, length: Int, index: Int) {
            val current = mns[curr]
            if (length < current.first || (length == current.first && index < current.second)) {
                mns[curr] = length to index
            }
        }

        private fun newNode(): Int {
            nodes.add(IntArray(26) { -1 })
            mns.add(Int.MAX_VALUE to Int.MAX_VALUE)
            return nodes.size - 1
        }
    }

    fun stringIndices(wordsContainer: Array<String>, wordsQuery: Array<String>): IntArray {
        val trie = Trie()
        for (i in wordsContainer.indices) {
            trie.add(i, wordsContainer[i])
        }
        val result = IntArray(wordsQuery.size)
        for (i in wordsQuery.indices) {
            result[i] = trie.query(wordsQuery[i])
        }
        return result
    }
}
