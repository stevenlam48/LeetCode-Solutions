package smallestintegerdivisiblebyk

// Time:  O(k)
// Space: O(1)

class Solution {
    fun smallestRepunitDivByK(K: Int): Int {
        if (K % 2 == 0 || K % 5 == 0) {
            return -1
        }
        var result = 0
        for (N in 1..K) {
            result = (result * 10 + 1) % K
            if (result == 0) {
                return N
            }
        }
        return -1
    }
}
