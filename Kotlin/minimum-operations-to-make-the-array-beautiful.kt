package minimumoperationstomakethearraybeautiful

// Time:  O(n * rlogr), r = max(nums)
// Space: O(r)

// dp
class Solution {
    fun minOperations(nums: IntArray): Int {
        fun ceilDivide(a: Int, b: Int): Int = (a + b - 1) / b

        val mx = nums.max()
        if (mx == 1) {
            return 0
        }
        val size = (2 * mx - 2) + 1
        var dp = IntArray(size) { Int.MAX_VALUE }
        dp[nums[0]] = 0
        for (i in 1 until nums.size) {
            val newDp = IntArray(size) { Int.MAX_VALUE }
            for (x in 1 until size) {
                if (dp[x] == Int.MAX_VALUE) {
                    continue
                }
                var j = ceilDivide(nums[i], x)
                while (j * x < size) {
                    val v = j * x
                    newDp[v] = minOf(newDp[v], dp[x] + (v - nums[i]))
                    ++j
                }
            }
            dp = newDp
        }
        return dp.min()
    }
}
