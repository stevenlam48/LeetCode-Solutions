package numberofsubarrayswithlcmequaltok
// Time:  O(n * sqrt(k) * logk)
// Space: O(sqrt(k))

class Solution {
    private fun gcd(a: Int, b: Int): Int {
        return if (b == 0) a else gcd(b, a % b)
    }

    private fun lcm(a: Int, b: Int): Int {
        return a / gcd(a, b) * b
    }

    fun subarrayLCM(nums: IntArray, k: Int): Int {
        var result = 0
        var dp = HashMap<Int, Int>()
        for (value in nums) {
            val newDp = HashMap<Int, Int>()
            if (k % value == 0) {
                dp[value] = dp.getOrDefault(value, 0) + 1
                for ((valueLcm, count) in dp) {
                    val next = lcm(valueLcm, value)
                    newDp[next] = newDp.getOrDefault(next, 0) + count
                }
            }
            dp = newDp
            result += dp.getOrDefault(k, 0)
        }
        return result
    }
}
