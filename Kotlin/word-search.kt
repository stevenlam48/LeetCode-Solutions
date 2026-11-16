package wordsearch

// Time:  O(m * n * 4 * 3^(l - 1)) ~= O(m * n * 3^l), l is the length of the word
// Space: O(l)

class Solution {
    fun exist(board: Array<CharArray>, word: String): Boolean {
        val m = board.size
        val n = board[0].size
        val visited = Array(m) { BooleanArray(n) }
        for (i in 0 until m) {
            for (j in 0 until n) {
                if (dfs(board, word, 0, i, j, visited)) return true
            }
        }
        return false
    }

    private fun dfs(
        board: Array<CharArray>,
        word: String,
        index: Int,
        i: Int,
        j: Int,
        visited: Array<BooleanArray>
    ): Boolean {
        if (index == word.length) return true
        if (i < 0 || j < 0 || i >= board.size || j >= board[0].size || visited[i][j] || board[i][j] != word[index]) {
            return false
        }
        visited[i][j] = true
        val result = dfs(board, word, index + 1, i + 1, j, visited) ||
            dfs(board, word, index + 1, i, j + 1, visited) ||
            dfs(board, word, index + 1, i - 1, j, visited) ||
            dfs(board, word, index + 1, i, j - 1, visited)
        visited[i][j] = false
        return result
    }
}
