package makeasquarewiththesamecolor

// Time:  O((n - w + 1)^2 * w^2)
// Space: O(1)

class Solution {
    fun canMakeSquare(grid: Array<CharArray>): Boolean {
        val n = 3
        val w = 2
        for (i in 0 until n - w + 1) {
            for (j in 0 until n - w + 1) {
                val cnt = IntArray(2)
                for (h in 0 until w) {
                    for (x in 0 until w) {
                        ++cnt[if (grid[i + h][j + x] == 'W') 0 else 1]
                    }
                }
                if (maxOf(cnt[0], cnt[1]) >= w * w - 1) {
                    return true
                }
            }
        }
        return false
    }
}
