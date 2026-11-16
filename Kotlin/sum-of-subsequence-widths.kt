package sumofsubsequencewidths

// Time:  O(n)
// Spce:  O(1)

class Solution {
    fun sumSubseqWidths(A: IntArray): Int {
        val M = 1e9.toInt() + 7
        A.sort()
        var result = 0L
        var c = 1L
        for (i in A.indices) {
            result = (result + (A[i] - A[A.size - 1 - i]) * c % M) % M
            c = (c shl 1) % M
        }
        return ((result + M) % M).toInt()
    }
}
