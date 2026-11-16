package pathwithmaximumminimumvalue

// Time:  O(m * n * log(m * n))
// Space: O(m * n)

class Solution {
    fun maximumMinimumPath(A: Array<IntArray>): Int {
        val vals = mutableListOf<Int>()
        val ceil = minOf(A[0][0], A[A.size - 1][A[0].size - 1])
        for (i in A.indices) {
            for (j in A[0].indices) {
                if (A[i][j] <= ceil) {
                    vals.add(A[i][j])
                }
            }
        }
        vals.sort()
        val uniq = vals.distinct()
        var left = 0
        var right = uniq.size - 1
        while (left <= right) {
            val mid = left + (right - left) / 2
            val lookup = HashSet<Long>()
            if (!check(A, uniq[mid], 0, 0, lookup)) {
                right = mid - 1
            } else {
                left = mid + 1
            }
        }
        return uniq[right]
    }

    private fun check(A: Array<IntArray>, value: Int, r: Int, c: Int, lookup: HashSet<Long>): Boolean {
        val directions = arrayOf(intArrayOf(0, 1), intArrayOf(1, 0), intArrayOf(0, -1), intArrayOf(-1, 0))
        if (r == A.size - 1 && c == A[0].size - 1) {
            return true
        }
        lookup.add(r.toLong() * A[0].size + c)
        for (d in directions) {
            val nr = r + d[0]
            val nc = c + d[1]
            if (0 <= nr && nr < A.size &&
                0 <= nc && nc < A[0].size &&
                (nr.toLong() * A[0].size + nc) !in lookup &&
                A[nr][nc] >= value &&
                check(A, value, nr, nc, lookup)) {
                return true
            }
        }
        return false
    }
}
