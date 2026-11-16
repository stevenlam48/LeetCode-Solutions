package minimumswapstomakesequencesincreasing

// Time:  O(n)
// Space: O(1)

class Solution {
    fun minSwap(A: IntArray, B: IntArray): Int {
        val dpNoSwap = IntArray(2)
        val dpSwap = IntArray(2) { 1 }
        for (i in 1 until A.size) {
            dpNoSwap[i % 2] = Int.MAX_VALUE
            dpSwap[i % 2] = Int.MAX_VALUE
            if (A[i - 1] < A[i] && B[i - 1] < B[i]) {
                dpNoSwap[i % 2] = minOf(dpNoSwap[i % 2], dpNoSwap[(i - 1) % 2])
                dpSwap[i % 2] = minOf(dpSwap[i % 2], dpSwap[(i - 1) % 2] + 1)
            }
            if (A[i - 1] < B[i] && B[i - 1] < A[i]) {
                dpNoSwap[i % 2] = minOf(dpNoSwap[i % 2], dpSwap[(i - 1) % 2])
                dpSwap[i % 2] = minOf(dpSwap[i % 2], dpNoSwap[(i - 1) % 2] + 1)
            }
        }
        val last = (A.size - 1) % 2
        return minOf(dpNoSwap[last], dpSwap[last])
    }
}
