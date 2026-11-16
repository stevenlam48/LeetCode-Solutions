package maximumproductoffirstandlastelementsofasubsequence

// Time:  O(n)
// Space: O(1)

// two pointers, sliding window
class Solution {
    fun maximumProduct(nums: IntArray, m: Int): Long {
        var result = Long.MIN_VALUE
        var mx = Int.MIN_VALUE
        var mn = Int.MAX_VALUE
        for (i in 0 until nums.size - (m - 1)) {
            mx = maxOf(mx, nums[i])
            mn = minOf(mn, nums[i])
            val last = nums[i + (m - 1)].toLong()
            result = maxOf(result, last * mx, last * mn)
        }
        return result
    }
}
