package sortthematrixdiagonally

// Time:  O(m * n * log(min(m, n))
// Space: O(m * n)

class Solution {
    fun diagonalSort(mat: Array<IntArray>): Array<IntArray> {
        val lookup = HashMap<Int, MutableList<Int>>()
        for (i in mat.indices) {
            for (j in mat[0].indices) {
                lookup.getOrPut(i - j) { mutableListOf() }.add(mat[i][j])
            }
        }
        for (values in lookup.values) {
            values.sort()
        }
        for (i in mat.size - 1 downTo 0) {
            for (j in mat[0].size - 1 downTo 0) {
                val values = lookup.getValue(i - j)
                mat[i][j] = values.removeAt(values.lastIndex)
            }
        }
        return mat
    }
}
