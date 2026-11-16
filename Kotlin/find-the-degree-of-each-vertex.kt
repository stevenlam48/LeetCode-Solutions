package findthedegreeofeachvertex

// Time:  O(n * m)
// Space: O(1)
class Solution {
    fun findDegrees(matrix: Array<IntArray>): IntArray {
        val result = ArrayList<Int>(matrix.size)
        for (row in matrix) {
            result.add(row.sum())
        }
        return result.toIntArray()
    }
}
