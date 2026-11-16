package partitionarrayintothreepartswithequalsum

// Time:  O(n)
// Space: O(1)

class Solution {
    fun canThreePartsEqualSum(A: IntArray): Boolean {
        val total = A.sum()
        if (total % 3 != 0) {
            return false
        }
        var curr = 0
        var parts = 0
        for (x in A) {
            curr += x
            if (curr == total / 3) {
                ++parts
                curr = 0
            }
        }
        return parts >= 3
    }
}
