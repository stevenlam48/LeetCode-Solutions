package scoreafterflippingmatrix

// Time:  O(r * c)
// Space: O(1)

class Solution {
    fun matrixScore(A: Array<IntArray>): Int {
        val R = A.size
        val C = A[0].size
        var result = 0
        for (c in 0 until C) {
            var col = 0
            for (r in 0 until R) {
                col += A[r][c] xor A[r][0]
            }
            result += maxOf(col, R - col) * (1 shl (C - 1 - c))
        }
        return result
    }
}
