package countpairswithxorinarange

// Time:  O(n)
// Space: O(n)

// dp solution
class Solution {
    fun countPairs(nums: IntArray, low: Int, high: Int): Int {
        return count(nums, high + 1) - count(nums, low)
    }

    private fun count(nums: IntArray, x0: Int): Int {
        var dp = HashMap<Int, Int>()
        for (v in nums) {
            dp[v] = (dp[v] ?: 0) + 1
        }
        var result = 0
        var x = x0
        while (x != 0) {
            val newDp = HashMap<Int, Int>()
            for ((k, v) in dp) {
                newDp[k shr 1] = (newDp[k shr 1] ?: 0) + v
                if ((x and 1) == 0) {
                    continue
                }
                val other = (x xor 1) xor k
                val c = dp[other]
                if (c != null) {
                    result += v * c
                }
            }
            dp = newDp
            x = x shr 1
        }
        return result / 2
    }
}
