package maximumbitwiseandafterincrementoperations

// Time:  O(nlogr)
// Space: O(n)

class Solution {
    fun maximumAND(nums: IntArray, k: Int, m: Int): Int {
        var result = 0
        val top = nums.max() + k
        for (i in 32 - Integer.numberOfLeadingZeros(top) - 1 downTo 0) {
            val target = result or (1 shl i)
            val costs = IntArray(nums.size)
            for (j in nums.indices) {
                val x = nums[j]
                val l = 32 - Integer.numberOfLeadingZeros(target and x.inv())
                val mask = (1L shl l) - 1
                costs[j] = ((target.toLong() and mask) - (x.toLong() and mask)).toInt()
            }
            costs.sort()
            var total = 0L
            for (j in 0 until m) {
                total += costs[j]
            }
            if (total <= k) {
                result = target
            }
        }
        return result
    }
}
