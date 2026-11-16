package deletecolumnstomakesortedii

// Time:  O(n * l)
// Space: O(n)
class Solution {
    fun minDeletionSize(A: Array<String>): Int {
        var result = 0
        val unsorted = HashSet<Int>()
        for (i in 0 until A.size - 1) unsorted.add(i)
        for (j in A[0].indices) {
            if (unsorted.any { i -> A[i][j] > A[i + 1][j] }) {
                ++result
            } else {
                val tmp = HashSet(unsorted)
                for (i in tmp) {
                    if (A[i][j] < A[i + 1][j]) unsorted.remove(i)
                }
            }
        }
        return result
    }
}
