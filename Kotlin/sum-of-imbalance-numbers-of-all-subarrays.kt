package sumofimbalancenumbersofallsubarrays

// Time:  O(n)
// Space: O(n)

// hash table, combinatorics
class Solution {
    fun sumImbalanceNumbers(nums: IntArray): Int {
        val n = nums.size
        val right = IntArray(n) { n }
        val lookup = IntArray(n + 2) { n }
        for (i in n - 1 downTo 0) {
            right[i] = minOf(lookup[nums[i]], lookup[nums[i] + 1])  // to avoid duplicated count
            lookup[nums[i]] = i
        }
        var result = 0
        lookup.fill(-1)
        for (i in 0 until n) {
            val left = lookup[nums[i] + 1]
            lookup[nums[i]] = i
            result += (i - left) * (right[i] - i)
        }
        return result - (n + 1) * n / 2  // since we overcount 1 in each subarray, we have to subtract all of them
    }
}
