package shortestuncommonsubstringinanarray

// Time:  O(n * l^2)
// Space: O(t)

class Solution {
    fun shortestSubstrings(arr: List<String>): List<String> {
        val trie = Trie()
        for (x in arr) {
            trie.add(x, 1)
        }
        val result = ArrayList<String>()
        for (x in arr) {
            trie.add(x, -1)
            result.add(trie.query(x))
            trie.add(x, 1)
        }
        return result
    }

    private class Trie {
        private val nodes = ArrayList<IntArray>()
        private val cnts = ArrayList<Int>()

        init {
            newNode()
        }

        fun add(s: String, d: Int) {
            for (i in s.indices) {
                var curr = 0
                for (j in i until s.length) {
                    val x = s[j] - 'a'
                    if (nodes[curr][x] == -1) {
                        nodes[curr][x] = newNode()
                    }
                    curr = nodes[curr][x]
                    cnts[curr] = cnts[curr] + d
                }
            }
        }

        fun query(s: String): String {
            var best: String? = null
            for (i in s.indices) {
                var curr = 0
                for (j in i until s.length) {
                    curr = nodes[curr][s[j] - 'a']
                    if (cnts[curr] == 0) {
                        val candidate = s.substring(i, j + 1)
                        val current = best
                        if (current == null || candidate.length < current.length ||
                            (candidate.length == current.length && candidate < current)
                        ) {
                            best = candidate
                        }
                        break
                    }
                }
            }
            return best ?: ""
        }

        private fun newNode(): Int {
            nodes.add(IntArray(26) { -1 })
            cnts.add(0)
            return nodes.size - 1
        }
    }
}
