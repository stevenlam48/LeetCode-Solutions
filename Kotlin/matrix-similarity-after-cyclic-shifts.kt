package matrixsimilarityaftercyclicshifts

// Time:  O(m * n)
// Space: O(1)

class Solution {
    fun areSimilar(mat: Array<IntArray>, k: Int): Boolean {
        for (row in mat) {
            for (j in row.indices) {
                if (row[j] != row[(j + k) % row.size]) {
                    return false
                }
            }
        }
        return true
    }
}
