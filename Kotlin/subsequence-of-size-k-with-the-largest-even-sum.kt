package subsequenceofsizekwiththelargestevensum

// Time:  O(n) on overage
// Space: O(1)

// quick select solution
class Solution {
    fun largestEvenSum(nums: IntArray, k: Int): Long {
        nums.sortDescending()
        var total = 0L
        for (i in 0 until k) {
            total += nums[i]
        }
        if (total % 2 == 0L) {
            return total
        }
        val minK = intArrayOf(Int.MAX_VALUE, Int.MAX_VALUE)
        for (i in 0 until k) {
            val p = nums[i] % 2
            minK[p] = minOf(minK[p], nums[i])
        }
        var result = -1L
        for (i in k until nums.size) {
            result = maxOf(result, total - minK[1 - nums[i] % 2] + nums[i])
        }
        return result
    }
}
