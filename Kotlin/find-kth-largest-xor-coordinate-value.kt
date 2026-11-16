package findkthlargestxorcoordinatevalue
// Time:  O(m * n) on average
// Space: O(m * n)

class Solution {
    fun kthLargestValue(matrix: Array<IntArray>, k: Int): Int {
        val vals = mutableListOf<Int>()
        for (r in matrix.indices) {
            var curr = 0
            for (c in matrix[0].indices) {
                curr = curr xor matrix[r][c]
                if (r == 0) {
                    matrix[r][c] = curr
                } else {
                    matrix[r][c] = curr xor matrix[r - 1][c]
                }
                vals.add(matrix[r][c])
            }
        }
        vals.sortDescending()
        return vals[k - 1]
    }
}
