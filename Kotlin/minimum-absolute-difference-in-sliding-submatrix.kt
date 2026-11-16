package minimumabsolutedifferenceinslidingsubmatrix

import java.util.TreeMap

// Time:  O(m * n * k^2)
// Space: O(k^2)

class Solution {
    fun minAbsDiff(grid: Array<IntArray>, k: Int): Array<IntArray> {
        val m = grid.size
        val n = grid[0].size
        val result = Array(m - k + 1) { IntArray(n - k + 1) { -1 } }
        val bst = TreeMap<Int, Int>()
        for (di in 0 until k) {
            for (dj in 0 until k) {
                bst.merge(grid[di][dj], 1, Int::plus)
            }
        }
        for (i in 0..m - k) {
            val bst2 = TreeMap(bst)
            for (j in 0..n - k) {
                var mn = Int.MAX_VALUE
                var prev: Int? = null
                for (x in bst2.keys) {
                    if (prev != null && x != prev) {
                        mn = minOf(mn, x - prev)
                    }
                    prev = x
                }
                result[i][j] = if (mn != Int.MAX_VALUE) mn else 0
                if (j + 1 == n - (k - 1)) {
                    continue
                }
                for (di in 0 until k) {
                    removeOne(bst2, grid[i + di][j])
                    bst2.merge(grid[i + di][j + k], 1, Int::plus)
                }
            }
            if (i + 1 == m - (k - 1)) {
                continue
            }
            for (dj in 0 until k) {
                removeOne(bst, grid[i][dj])
                bst.merge(grid[i + k][dj], 1, Int::plus)
            }
        }
        return result
    }

    private fun removeOne(map: TreeMap<Int, Int>, key: Int) {
        val c = map[key]!!
        if (c == 1) {
            map.remove(key)
        } else {
            map[key] = c - 1
        }
    }
}
