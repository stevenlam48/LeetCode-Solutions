package findthelengthofthelongestcommonprefix
// Time:  O((n + m) * l)
// Space: O(t)

class Solution {
    private class Trie {
        private val nodes = mutableListOf<IntArray>()

        init {
            newNode()
        }

        fun add(w: String) {
            var curr = 0
            for (c in w) {
                val k = c - '0'
                if (nodes[curr][k] == -1) {
                    nodes[curr][k] = newNode()
                }
                curr = nodes[curr][k]
            }
        }

        fun query(w: String): Int {
            var curr = 0
            for (i in w.indices) {
                val k = w[i] - '0'
                if (nodes[curr][k] == -1) {
                    return i
                }
                curr = nodes[curr][k]
            }
            return w.length
        }

        private fun newNode(): Int {
            nodes.add(IntArray(10) { -1 })
            return nodes.size - 1
        }
    }

    fun longestCommonPrefix(arr1: IntArray, arr2: IntArray): Int {
        val trie = Trie()
        for (x in arr1) {
            trie.add(x.toString())
        }
        var result = 0
        for (x in arr2) {
            result = maxOf(result, trie.query(x.toString()))
        }
        return result
    }
}
