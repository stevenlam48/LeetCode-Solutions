package minimumvalueofmergedintegers

// Time:  O(nlogr)
// Space: O(1)

// array
class Solution {
    fun minMergedInteger(nums: IntArray): Int {
        fun length(x0: Int): Int {
            var x = x0
            var result = 0
            while (x != 0) {
                ++result
                x /= 10
            }
            return result
        }

        fun f(x: Int, y: Int): Int = x * Math.pow(10.0, length(y).toDouble()).toInt() + y

        var mn = Int.MAX_VALUE
        var i = 0
        while (2 * i < nums.size) {
            mn = minOf(mn, f(nums[2 * i], nums[2 * i + 1]))
            ++i
        }
        return mn
    }
}
