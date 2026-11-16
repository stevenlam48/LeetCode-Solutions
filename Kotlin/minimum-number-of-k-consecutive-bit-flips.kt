package minimumnumberofkconsecutivebitflips

// Time:  O(n)
// Space: O(1)

class Solution {
    fun minKBitFlips(A: IntArray, K: Int): Int {
        var result = 0
        var curr = 0
        for (i in A.indices) {
            if (i >= K) {
                curr -= A[i - K] / 2
            }
            if (A[i] == (curr and 1)) {
                if (i + K > A.size) {
                    return -1
                }
                A[i] += 2
                ++curr
                ++result
            }
        }
        return result
    }
}
