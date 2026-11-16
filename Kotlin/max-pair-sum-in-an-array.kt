package maxpairsuminanarray

// Time:  O(nlogr)
// Space: O(1)

class Solution {
    fun maxSum(nums: IntArray): Int {
        fun maxDigit(value: Int): Int {
            var x = value
            var result = 0
            while (x != 0) {
                result = maxOf(result, x % 10)
                x /= 10
            }
            return result
        }

        var result = -1
        val lookup = IntArray(10) { -1 }
        for (x in nums) {
            val mx = maxDigit(x)
            if (lookup[mx] == -1) {
                lookup[mx] = x
                continue
            }
            result = maxOf(result, lookup[mx] + x)
            lookup[mx] = maxOf(lookup[mx], x)
        }
        return result
    }
}
