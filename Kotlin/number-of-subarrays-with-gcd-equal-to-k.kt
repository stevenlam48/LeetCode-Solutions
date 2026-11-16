package numberofsubarrayswithgcdequaltok
// Time:  O(nlogr), r = max(nums)
// Space: O(logr)

class Solution {
    private fun gcd(a: Int, b: Int): Int {
        return if (b == 0) a else gcd(b, a % b)
    }

    fun subarrayGCD(nums: IntArray, k: Int): Int {
        var result = 0
        var dp = HashMap<Int, Int>()
        for (value in nums) {
            val newDp = HashMap<Int, Int>()
            if (value % k == 0) {
                dp[value] = dp.getOrDefault(value, 0) + 1
                for ((divisor, count) in dp) {
                    val next = gcd(divisor, value)
                    newDp[next] = newDp.getOrDefault(next, 0) + count
                }
            }
            dp = newDp
            result += dp.getOrDefault(k, 0)
        }
        return result
    }
}
