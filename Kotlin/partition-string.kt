package partitionstring

// Time:  O(n)
// Space: O(t)

class Solution {
    fun partitionString(s: String): List<String> {
        val result = mutableListOf<String>()
        val trie = Trie()
        var curr = StringBuilder()
        for (c in s) {
            curr.append(c)
            trie.add(c)
            if (trie.curr() != 0) {
                continue
            }
            result.add(curr.toString())
            curr = StringBuilder()
        }
        return result
    }

    private class Trie {
        private val nodes = mutableListOf<IntArray>()
        private var current = 0

        init {
            newNode()
        }

        fun add(c: Char) {
            val x = c - 'a'
            if (nodes[current][x] == -1) {
                nodes[current][x] = newNode()
                current = 0
                return
            }
            current = nodes[current][x]
        }

        fun curr(): Int = current

        private fun newNode(): Int {
            nodes.add(IntArray(26) { -1 })
            return nodes.size - 1
        }
    }
}
