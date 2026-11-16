package makethexorofallsegmentsequaltozero

// Time:  O(n + k * m), m is the max number of nums
// Space: O(min(k * m, n))

class Solution {
    fun minChanges(nums: IntArray, k: Int): Int {
        val cnts = Array(k) { HashMap<Int, Int>() }
        for (i in nums.indices) {
            cnts[i % k].merge(nums[i], 1, Int::plus)
        }
        return minOf(oneAreNotFromNums(nums, cnts), allAreFromNums(nums, cnts))
    }

    private fun allAreFromNums(nums: IntArray, cnts: Array<HashMap<Int, Int>>): Int {
        var dp = HashMap<Int, Int>()
        dp[0] = 0
        for (cnt in cnts) {
            val newDp = HashMap<Int, Int>()
            for ((x, dpX) in dp) {
                for ((y, cntY) in cnt) {
                    val key = x xor y
                    newDp[key] = maxOf(newDp[key] ?: 0, dpX + cntY)
                }
            }
            dp = newDp
        }
        return nums.size - (dp[0] ?: 0)
    }

    private fun oneAreNotFromNums(nums: IntArray, cnts: Array<HashMap<Int, Int>>): Int {
        var totMx = 0
        var mnMx = Int.MAX_VALUE
        for (cnt in cnts) {
            val mx = cnt.values.maxOrNull() ?: 0
            totMx += mx
            mnMx = minOf(mnMx, mx)
        }
        return nums.size - (totMx - mnMx)
    }
}
