package designsearchautocompletesystem

// Time:  O(p^2), p is the length of the prefix
// Space: O(p * t + s), t is the number of nodes of trie
//                    , s is the size of the sentences

class AutocompleteSystem(sentences: List<String>, times: IntArray) {
    private val sentenceToCount = HashMap<String, Int>()
    private val trie = TrieNode()
    private var curNode: TrieNode? = trie
    private val search = StringBuilder()

    init {
        for (i in sentences.indices) {
            sentenceToCount[sentences[i]] = times[i]
            trie.insert(sentences[i], sentenceToCount[sentences[i]]!!)
        }
    }

    fun input(c: Char): List<String> {
        val result = ArrayList<String>()
        if (c == '#') {
            val count = sentenceToCount.getOrDefault(search.toString(), 0) + 1
            sentenceToCount[search.toString()] = count
            trie.insert(search.toString(), count)
            curNode = trie
            search.setLength(0)
        } else {
            search.append(c)
            val node = curNode
            if (node != null) {
                val next = node.leaves[c]
                if (next == null) {
                    curNode = null
                    return emptyList()
                }
                curNode = next
                for ((_, s) in next.infos) {
                    result.add(s)
                }
            }
        }
        return result
    }

    private class TrieNode {
        val infos = ArrayList<Pair<Int, String>>()
        val leaves = HashMap<Char, TrieNode>()

        fun insert(s: String, times: Int) {
            var cur = this
            cur.addInfo(s, times)
            for (c in s) {
                val next = cur.leaves.getOrPut(c) { TrieNode() }
                cur = next
                cur.addInfo(s, times)
            }
        }

        fun addInfo(s: String, times: Int) {
            val it = infos.indexOfFirst { it.second == s }
            if (it != -1) {
                infos[it] = Pair(-times, s)
            } else {
                infos.add(Pair(-times, s))
            }
            infos.sortWith(compareBy({ it.first }, { it.second }))
            if (infos.size > TOP_COUNT) {
                infos.removeAt(infos.size - 1)
            }
        }

        companion object {
            private const val TOP_COUNT = 3
        }
    }
}
