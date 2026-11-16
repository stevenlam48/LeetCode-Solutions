package creategridwithexactlyonepath

// Time:  O(m * n)
// Space: O(1)

class Solution {
    fun createGrid(m: Int, n: Int): Array<String> {
        val result = Array(m) { CharArray(n) { '#' } }
        for (j in 0 until n) {
            result[0][j] = '.'
        }
        for (i in 0 until m) {
            result[i][n - 1] = '.'
        }
        return Array(m) { String(result[it]) }
    }
}
