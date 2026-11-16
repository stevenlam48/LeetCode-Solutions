package partitionarrayintodisjointintervals

// Time:  O(n)
// Space: O(n)

class Solution {
    fun partitionDisjoint(A: IntArray): Int {
        val b = A.copyOf()
        for (i in A.size - 2 downTo 1) {
            b[i] = minOf(b[i], b[i + 1])
        }
        var pMax = 0
        for (i in 1 until A.size) {
            pMax = maxOf(pMax, A[i - 1])
            if (pMax <= b[i]) {
                return i
            }
        }
        return -1
    }
}
