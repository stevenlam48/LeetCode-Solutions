package countsubmatriceswithallones
// Time:  O(m * n)
// Space: O(n)

class Solution {
    fun numSubmat(mat: Array<IntArray>): Int {
        fun count(heights: IntArray): Int {
            var result = 0
            val stk = mutableListOf<Int>()
            var curr = 0
            for (i in heights.indices) {
                while (stk.isNotEmpty() && heights[stk.last()] >= heights[i]) {
                    val j = stk.removeAt(stk.lastIndex)
                    curr -= (heights[j] - heights[i]) * (j - if (stk.isNotEmpty()) stk.last() else -1)
                }
                stk.add(i)
                curr += heights[i]
                result += curr
            }
            return result
        }

        var result = 0
        val heights = IntArray(mat[0].size)
        for (i in mat.indices) {
            for (j in mat[0].indices) {
                heights[j] = if (mat[i][j] == 1) heights[j] + 1 else 0
            }
            result += count(heights)
        }
        return result
    }
}
