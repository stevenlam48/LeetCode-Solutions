package numberofsubmatricesthatsumtotarget
// Time:  O(m^2*n), m is min(r, c), n is max(r, c)
// Space: O(n), which doesn't include transposed space

class Solution {
    private fun transpose(matrix: Array<IntArray>): Array<IntArray> {
        val result = Array(matrix[0].size) { IntArray(matrix.size) }
        for (i in matrix.indices) {
            for (j in matrix[i].indices) {
                result[j][i] = matrix[i][j]
            }
        }
        return result
    }

    fun numSubmatrixSumTarget(matrix: Array<IntArray>, target: Int): Int {
        if (matrix.size > matrix[0].size) {
            return numSubmatrixSumTarget(transpose(matrix), target)
        }
        for (i in matrix.indices) {
            for (j in 0 until matrix[i].size - 1) {
                matrix[i][j + 1] += matrix[i][j]
            }
        }
        var result = 0
        for (i in matrix.indices) {
            val prefixSum = IntArray(matrix[i].size)
            for (j in i until matrix.size) {
                val lookup = HashMap<Int, Int>()
                lookup[0] = 1
                for (k in matrix[i].indices) {
                    prefixSum[k] += matrix[j][k]
                    result += lookup.getOrDefault(prefixSum[k] - target, 0)
                    lookup[prefixSum[k]] = lookup.getOrDefault(prefixSum[k], 0) + 1
                }
            }
        }
        return result
    }
}
