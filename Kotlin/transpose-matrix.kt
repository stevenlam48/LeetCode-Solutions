package transposematrix
// Time:  O(r * c)
// Space: O(1)

class Solution {
    fun transpose(A: Array<IntArray>): Array<IntArray> {
        val result = Array(A[0].size) { IntArray(A.size) }
        for (r in A.indices) {
            for (c in A[0].indices) {
                result[c][r] = A[r][c]
            }
        }
        return result
    }
}
