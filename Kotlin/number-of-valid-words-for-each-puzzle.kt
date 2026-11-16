package numberofvalidwordsforeachpuzzle

// Time:  O(n*l + m*L), m is the number of puzzles, L is the length of puzzles
//                    , n is the number of words, l is the max length of words
// Space: O(L!)

class Solution {
    fun findNumOfValidWords(words: List<String>, puzzles: List<String>): IntArray {
        val L = 7
        val trie = TrieNode()
        for (word in words) {
            val count = IntArray(26)
            for (c in word) {
                count[c - 'a'] = 1
            }
            val total = count.sum()
            if (total > L) {
                continue
            }
            trie.insert(count)
        }
        val result = IntArray(puzzles.size)
        for (idx in puzzles.indices) {
            val puzzle = puzzles[idx]
            val first = puzzle[0]
            val sorted = puzzle.toCharArray()
            sorted.sort()
            result[idx] = search(trie, sorted, 0, first, false)
        }
        return result
    }

    private fun search(node: TrieNode, puzzle: CharArray, start: Int, first: Char, metFirst: Boolean): Int {
        var result = 0
        if (metFirst) {
            result += node.endCount
        }
        for (i in start until puzzle.size) {
            val child = node.children[puzzle[i] - 'a'] ?: continue
            result += search(child, puzzle, i + 1, first, metFirst || puzzle[i] == first)
        }
        return result
    }

    private class TrieNode {
        var endCount = 0
        val children = arrayOfNulls<TrieNode>(26)

        fun insert(count: IntArray) {
            var p = this
            for (i in count.indices) {
                if (count[i] == 0) {
                    continue
                }
                if (p.children[i] == null) {
                    p.children[i] = TrieNode()
                }
                p = p.children[i]!!
            }
            ++p.endCount
        }
    }
}
