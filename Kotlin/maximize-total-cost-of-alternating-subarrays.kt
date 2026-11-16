package maximizetotalcostofalternatingsubarrays

// Time:  O(n)
// Space: O(1)

class Solution {
    fun maximumTotalCost(nums: IntArray): Long {
        var a = nums[0].toLong()
        var b = Long.MIN_VALUE
        for (i in 1 until nums.size) {
            val nextA = maxOf(a, b) + nums[i]
            val nextB = a - nums[i]
            a = nextA
            b = nextB
        }
        return maxOf(a, b)
    }
}
