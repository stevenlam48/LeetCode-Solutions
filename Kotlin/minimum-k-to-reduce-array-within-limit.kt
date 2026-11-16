package minimumktoreducearraywithinlimit

// Time:  O(nlogr + nlogn)
// Space: O(1)

import kotlin.math.ceil
import kotlin.math.sqrt

class Solution {
    fun minimumK(nums: IntArray): Int {
        fun binarySearch(startLeft: Int, startRight: Int, check: (Int) -> Boolean): Int {
            var left = startLeft
            var right = startRight
            while (left <= right) {
                val mid = left + (right - left) / 2
                if (check(mid)) {
                    right = mid - 1
                } else {
                    left = mid + 1
                }
            }
            return left
        }

        fun ceilDivide(a: Int, b: Int): Int = (a + b - 1) / b

        fun check(k: Int): Boolean {
            var result = 0L
            for (x in nums) {
                result += ceilDivide(x, k)
                if (result > k.toLong() * k) {
                    return false
                }
            }
            return true
        }

        val right = maxOf(nums.max(), ceil(sqrt(nums.size.toDouble())).toInt())
        return binarySearch(1, right, ::check)
    }
}
