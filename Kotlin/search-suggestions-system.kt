package searchsuggestionssystem

// Time:  ctor: O(n * l), n is the number of products
//                      , l is the average length of product name
//        suggest: O(l^2)
// Space: O(t), t is the number of nodes in trie

class Solution {
    fun suggestedProducts(products: List<String>, searchWord: String): List<List<String>> {
        val trie = TrieNode()
        for (i in products.indices) {
            trie.insert(products, i)
        }
        var curr = trie
        val result = MutableList(searchWord.length) { mutableListOf<String>() }
        for (i in searchWord.indices) {
            if (!curr.leaves.containsKey(searchWord[i])) {
                break
            }
            curr = curr.leaves.getValue(searchWord[i])
            for (j in curr.infos) {
                result[i].add(products[j])
            }
        }
        return result
    }

    private class TrieNode {
        val infos = mutableListOf<Int>()
        val leaves = hashMapOf<Char, TrieNode>()

        fun insert(words: List<String>, i: Int) {
            var curr = this
            for (c in words[i]) {
                if (!curr.leaves.containsKey(c)) {
                    curr.leaves[c] = TrieNode()
                }
                curr = curr.leaves.getValue(c)
                curr.addInfo(words, i)
            }
        }

        fun addInfo(words: List<String>, i: Int) {
            infos.add(i)
            infos.sortWith(compareBy { words[it] })
            if (infos.size > TOP_COUNT) {
                infos.removeAt(infos.lastIndex)
            }
        }
    }

    private companion object {
        const val TOP_COUNT = 3
    }
}
