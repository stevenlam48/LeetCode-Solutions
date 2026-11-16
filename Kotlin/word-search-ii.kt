package wordsearchii

// Time:  O(m * n * 4 * 3^(h - 1)) ~= O(m * n * 3^h), h is the height of trie
// Space: O(t), t is the number of nodes in trie

class Solution {
    private class TrieNode {
        var isString = false
        val leaves = HashMap<Char, TrieNode>()

        fun insert(s: String): Boolean {
            var node = this
            for (c in s) {
                node = node.leaves.getOrPut(c) { TrieNode() }
            }
            if (node.isString) return false
            node.isString = true
            return true
        }
    }

    fun findWords(board: Array<CharArray>, words: List<String>): List<String> {
        val result = HashSet<String>()
        val visited = Array(board.size) { BooleanArray(board[0].size) }
        val trie = TrieNode()
        for (word in words) trie.insert(word)
        for (i in board.indices) {
            for (j in board[0].indices) {
                findWordsDfs(board, visited, trie, i, j, "", result)
            }
        }
        return result.toList()
    }

    private fun findWordsDfs(
        grid: Array<CharArray>,
        visited: Array<BooleanArray>,
        trie: TrieNode?,
        i: Int,
        j: Int,
        current: String,
        result: MutableSet<String>
    ) {
        if (trie == null || i < 0 || i >= grid.size || j < 0 || j >= grid[0].size) return
        val nextNode = trie.leaves[grid[i][j]]
        if (nextNode == null || visited[i][j]) return
        val next = current + grid[i][j]
        if (nextNode.isString) result.add(next)
        visited[i][j] = true
        val directions = arrayOf(0 to -1, 0 to 1, -1 to 0, 1 to 0)
        for ((di, dj) in directions) {
            findWordsDfs(grid, visited, nextNode, i + di, j + dj, next, result)
        }
        visited[i][j] = false
    }
}
