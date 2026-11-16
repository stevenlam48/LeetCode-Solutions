package subarraysumsdivisiblebyk

// Time:  O(n)
// Space: O(k)

class Solution {
    fun subarraysDivByK(A: IntArray, K: Int): Int {
        val count = HashMap<Int, Int>()
        count[0] = 1
        var prefix = 0
        var result = 0
        for (a in A) {
            prefix = (prefix + (a % K + K)) % K
            result += count[prefix] ?: 0
            count[prefix] = (count[prefix] ?: 0) + 1
        }
        return result
    }
}
