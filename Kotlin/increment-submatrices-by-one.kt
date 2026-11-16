package incrementsubmatricesbyone

// Time:  O(q + n^2)
// Space: O(1)

// line sweep, difference matrix (2d difference array)
class Solution {
    fun rangeAddQueries(n: Int, queries: Array<IntArray>): Array<IntArray> {
        val result = Array(n) { IntArray(n) }
        for (op in queries) {
            ++result[op[0]][op[1]]
            if (op[3] + 1 < result[0].size) {
                --result[op[0]][op[3] + 1]
            }
            if (op[2] + 1 < result.size) {
                --result[op[2] + 1][op[1]]
            }
            if (op[2] + 1 < result.size && op[3] + 1 < result[0].size) {
                ++result[op[2] + 1][op[3] + 1]
            }
        }
        for (r in result.indices) {
            for (c in 0 until result[0].size - 1) {
                result[r][c + 1] += result[r][c]
            }
        }
        for (r in 0 until result.size - 1) {
            for (c in result[0].indices) {
                result[r + 1][c] += result[r][c]
            }
        }
        return result
    }
}
