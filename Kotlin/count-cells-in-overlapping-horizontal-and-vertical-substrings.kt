package countcellsinoverlappinghorizontalandverticalsubstrings

// Time:  O(n * m)
// Space: O(n * m)

class Solution {
    fun countCells(grid: Array<CharArray>, pattern: String): Int {
        fun zFunction(s: String): IntArray {
            val z = IntArray(s.length)
            var l = 0
            var r = 0
            for (i in 1 until z.size) {
                if (i <= r) {
                    z[i] = minOf(r - i + 1, z[i - l])
                }
                while (i + z[i] < z.size && s[z[i]] == s[i + z[i]]) {
                    ++z[i]
                }
                if (i + z[i] - 1 > r) {
                    l = i
                    r = i + z[i] - 1
                }
            }
            return z
        }

        fun check(isHorizontal: Boolean): Array<BooleanArray> {
            var n = grid.size
            var m = grid[0].size
            if (!isHorizontal) {
                n = m.also { m = n }
            }
            val p = pattern.length
            val s = StringBuilder(pattern)
            for (i in 0 until n) {
                for (j in 0 until m) {
                    s.append(if (isHorizontal) grid[i][j] else grid[j][i])
                }
            }
            val lookup = Array(n) { BooleanArray(m) }
            val z = zFunction(s.toString())
            var curr = -p
            for (i in p until s.length) {
                if (z[i] < p) {
                    continue
                }
                curr = maxOf(curr, i - p)
                while (curr <= i - p + p - 1) {
                    lookup[curr / m][curr % m] = true
                    ++curr
                }
            }
            return lookup
        }

        val lookup1 = check(true)
        val lookup2 = check(false)
        var result = 0
        for (i in grid.indices) {
            for (j in grid[0].indices) {
                if (lookup1[i][j] && lookup2[j][i]) {
                    ++result
                }
            }
        }
        return result
    }
}
