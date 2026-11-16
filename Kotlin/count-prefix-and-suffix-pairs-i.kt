package countprefixandsuffixpairsi

// Time:  O(n * l)
// Space: O(t)

class Solution {
    private class Trie {
        private val nodes = mutableListOf<HashMap<Int, Int>>()
        private val counts = mutableListOf<Int>()

        init {
            newNode()
        }

        fun add(word: String): Int {
            var result = 0
            var current = 0
            for (i in word.indices) {
                val key = (word[i] - 'a') * 26 + (word[word.length - 1 - i] - 'a')
                if (!nodes[current].containsKey(key)) {
                    nodes[current][key] = newNode()
                }
                current = nodes[current][key]!!
                result += counts[current]
            }
            ++counts[current]
            return result
        }

        private fun newNode(): Int {
            nodes.add(HashMap())
            counts.add(0)
            return nodes.size - 1
        }
    }

    fun countPrefixSuffixPairs(words: List<String>): Long {
        var result = 0L
        val trie = Trie()
        for (word in words) {
            result += trie.add(word)
        }
        return result
    }
}
