package longestarithmeticsequenceafterchangingatmostoneelement

// Time:  O(n)
// Space: O(1)

// two pointers
class Solution {
    fun longestArithmetic(nums: IntArray): Int {
        fun f(a: IntArray): Int {
            var result = 2
            var left = 0
            var right = 2
            var diff = a[1] - a[0]
            while (right < a.size) {
                val curr = a[right] - a[right - 1]
                if (curr == diff) {
                    result = maxOf(result, right - left + 1)
                    ++right
                    continue
                }
                var r = right
                while (r + 1 < a.size &&
                    a[r + 1] - (if (r != right) a[r] else a[right - 1] + diff) == diff) {
                    ++r
                }
                result = maxOf(result, r - left + 1)
                left = right - 1
                diff = curr
                ++right
            }
            return result
        }

        var result = f(nums)
        result = maxOf(result, f(nums.reversedArray()))
        return result
    }
}
