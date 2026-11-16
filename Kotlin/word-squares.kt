package wordsquares

// Time:  O(n^2 * n!)
// Space: O(n^2)

class Solution {
    private class TrieNode {
        val indices = mutableListOf<Int>()
        val children = arrayOfNulls<TrieNode>(26)
    }

    private fun buildTrie(words: List<String>): TrieNode {
        val root = TrieNode()
        for (i in words.indices) {
            var node = root
            for (c in words[i]) {
                val index = c - 'a'
                if (node.children[index] == null) node.children[index] = TrieNode()
                node = node.children[index]!!
                node.indices.add(i)
            }
        }
        return root
    }

    fun wordSquares(words: List<String>): List<List<String>> {
        val result = mutableListOf<List<String>>()
        val trie = buildTrie(words)
        val current = mutableListOf<String>()
        for (word in words) {
            current.add(word)
            wordSquaresHelper(words, trie, current, result)
            current.removeAt(current.lastIndex)
        }
        return result
    }

    private fun wordSquaresHelper(
        words: List<String>,
        trie: TrieNode,
        current: MutableList<String>,
        result: MutableList<List<String>>
    ) {
        if (current.size == words[0].length) {
            result.add(current.toList())
            return
        }
        var node: TrieNode? = trie
        for (word in current) {
            node = node?.children[word[current.size] - 'a']
            if (node == null) return
        }
        for (i in node!!.indices) {
            current.add(words[i])
            wordSquaresHelper(words, trie, current, result)
            current.removeAt(current.lastIndex)
        }
    }
}
