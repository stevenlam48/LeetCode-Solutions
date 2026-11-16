package determinewhethermatrixcanbeobtainedbyrotation

// Time:  O(m * n)
// Space: O(1)

class Solution {
    fun findRotation(mat: Array<IntArray>, target: Array<IntArray>): Boolean {
        val checks = listOf<(Int, Int) -> Boolean>(
            { i, j -> mat[i][j] == target[i][j] },
            { i, j -> mat[i][j] == target[j][mat.size - 1 - i] },
            { i, j -> mat[i][j] == target[mat.size - 1 - i][mat[0].size - 1 - j] },
            { i, j -> mat[i][j] == target[mat[0].size - 1 - j][i] }
        )
        fun traverse(check: (Int, Int) -> Boolean): Boolean {
            for (i in mat.indices) {
                for (j in mat[0].indices) {
                    if (!check(i, j)) {
                        return false
                    }
                }
            }
            return true
        }
        for (check in checks) {
            if (traverse(check)) {
                return true
            }
        }
        return false
    }
}
