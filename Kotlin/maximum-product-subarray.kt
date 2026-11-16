package maximumproductsubarray

// Time:  O(n)
// Space: O(1)

class Solution {
    fun maxProduct(nums: IntArray): Int {
        var result = Int.MIN_VALUE
        var currMin = 1
        var currMax = 1
        for (num in nums) {
            val a = num
            val b = currMin * num
            val c = currMax * num
            currMin = minOf(a, b, c)
            currMax = maxOf(a, b, c)
            result = maxOf(result, currMax)
        }
        return result
    }
}
