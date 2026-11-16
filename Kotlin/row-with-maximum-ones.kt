package rowwithmaximumones

// Time:  O(m * n)
// Space: O(1)

// array
class Solution {
    fun rowAndMaximumOnes(mat: Array<IntArray>): IntArray {
        var result = intArrayOf(-1, -1)
        for (i in mat.indices) {
            var curr = 0
            for (x in mat[i]) {
                curr += x
            }
            if (curr > result[1]) {
                result = intArrayOf(i, curr)
            }
        }
        return result
    }
}
