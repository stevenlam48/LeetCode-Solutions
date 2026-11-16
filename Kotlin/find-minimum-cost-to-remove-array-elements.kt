package findminimumcosttoremovearrayelements

// Time:  O(n^2)
// Space: O(n)

class Solution {
    fun minCost(nums: IntArray): Int {
        var dp = HashMap<Int, Int>()
        dp[nums[0]] = 0
        var i = 1
        while (i + 1 < nums.size) {
            val newDp = HashMap<Int, Int>()
            val x = nums[i]
            val y = nums[i + 1]
            for ((z, c) in dp) {
                val v = intArrayOf(x, y, z)
                v.sort()
                newDp[v[0]] = if (newDp.containsKey(v[0])) minOf(newDp[v[0]]!!, c + v[2]) else c + v[2]
                newDp[v[2]] = if (newDp.containsKey(v[2])) minOf(newDp[v[2]]!!, c + v[1]) else c + v[1]
            }
            dp = newDp
            i += 2
        }
        val last = if (nums.size % 2 == 0) nums[nums.size - 1] else 0
        var result = Int.MAX_VALUE
        for ((x, c) in dp) {
            result = minOf(result, c + maxOf(x, last))
        }
        return result
    }
}
