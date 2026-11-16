package checkifeveryrowandcolumncontainsallnumbers

// Time:  O(n^2)
// Space: O(n)
class Solution {
    fun checkValid(matrix: Array<IntArray>): Boolean {
        for (i in matrix.indices) {
            val r = HashSet<Int>()
            val c = HashSet<Int>()
            for (j in matrix[0].indices) {
                r.add(matrix[i][j])
                c.add(matrix[j][i])
            }
            if (r.size != matrix[0].size || c.size != matrix.size) {
                return false
            }
        }
        return true
    }
}
