package minimumoperationstomakeallgridelementsequal

// Time:  O(m * n)
// Space: O(k * n)

class Solution {
    fun minOperations(grid: Array<IntArray>, k: Int): Long {
        var c = 0L
        var target = 0L
        var mn = Long.MIN_VALUE
        var found = false
        val lookup = Array(k) { LongArray(grid[0].size) }
        val cnt = LongArray(grid[0].size)
        for (i in grid.indices) {
            var total = 0L
            for (j in grid[0].indices) {
                total += cnt[j]
                val diff = -(grid[i][j] + total)
                if (i + k - 1 < grid.size && j + k - 1 < grid[0].size) {
                    lookup[i % k][j] = diff
                    cnt[j] += diff
                    total += diff
                    c += diff
                    if (i % k == 0 && j % k == 0) {
                        mn = maxOf(mn, -diff)
                    } else if (diff < 0) {
                        return -1
                    }
                } else {
                    if ((i / k + 1) * k <= grid.size && (j / k + 1) * k <= grid[0].size) {
                        if (diff != 0L) {
                            return -1
                        }
                    } else {
                        if (!found) {
                            found = true
                            target = -diff
                        } else if (target != -diff) {
                            return -1
                        }
                    }
                }
                if (j - k + 1 >= 0) {
                    total -= cnt[j - k + 1]
                }
            }
            if (i - k + 1 >= 0) {
                for (j in grid[0].indices) {
                    cnt[j] -= lookup[(i - k + 1) % k][j]
                    lookup[(i - k + 1) % k][j] = 0
                }
            }
        }
        if (!found) {
            target = mn
        } else if (target < mn) {
            return -1
        }
        return c + target * ((grid.size / k) * (grid[0].size / k))
    }
}
