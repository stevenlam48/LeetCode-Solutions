package p4sumii

// Time:  O(n^2)
// Space: O(n^2)

class Solution {
    fun fourSumCount(A: IntArray, B: IntArray, C: IntArray, D: IntArray): Int {
        val aBSum = HashMap<Int, Int>()
        for (a in A) {
            for (b in B) {
                aBSum[a + b] = (aBSum[a + b] ?: 0) + 1
            }
        }
        var result = 0
        for (c in C) {
            for (d in D) {
                val key = -c - d
                aBSum[key]?.let {
                    result += it
                }
            }
        }
        return result
    }
}
