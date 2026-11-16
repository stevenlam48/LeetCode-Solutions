package thekweakestrowsinamatrix

// Time:  O(m * n)
// Space: O(k)

class Solution {
    fun kWeakestRows(mat: Array<IntArray>, k: Int): IntArray {
        val result = ArrayList<Int>()
        val lookup = HashSet<Int>()
        for (j in mat[0].indices) {
            for (i in mat.indices) {
                if (mat[i][j] != 0 || lookup.contains(i)) {
                    continue
                }
                lookup.add(i)
                result.add(i)
                if (result.size == k) {
                    return result.toIntArray()
                }
            }
        }
        for (i in mat.indices) {
            if (lookup.contains(i)) {
                continue
            }
            lookup.add(i)
            result.add(i)
            if (result.size == k) {
                break
            }
        }
        return result.toIntArray()
    }
}
