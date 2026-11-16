package numberofsubarrayswithoddsum
// Time:  O(n)
// Space: O(1)

class Solution {
    fun numOfSubarrays(arr: IntArray): Int {
        val mod = 1_000_000_007
        var result = 0
        var accumulated = 0
        val dp = IntArray(2)
        ++dp[0]
        for (value in arr) {
            accumulated = accumulated xor (value and 1)
            ++dp[accumulated]
            result = (result + dp[accumulated xor 1]) % mod
        }
        return result
    }
}
