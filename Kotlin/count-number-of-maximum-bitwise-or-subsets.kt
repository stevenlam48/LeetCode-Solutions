package countnumberofmaximumbitwiseorsubsets

// Time:  O(min(2^n, m * n)), m is the 'bitwise or' of nums
// Space: O(min(2^n, m))

class Solution {
    fun countMaxOrSubsets(nums: IntArray): Int {
        var dp = hashMapOf(0 to 1)
        var total = 0
        for (x in nums) {
            val newDp = HashMap(dp)
            for ((k, v) in dp) {
                newDp[k or x] = newDp.getOrDefault(k or x, 0) + v
            }
            dp = newDp
            total = total or x
        }
        return dp.getOrDefault(total, 0)
    }
}
