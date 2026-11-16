package differencebetweenelementsumanddigitsumofanarray

import kotlin.math.abs

// Time:  O(nlogr), r = max(nums)
// Space: O(1)

// array
class Solution {
    fun differenceOfSum(nums: IntArray): Int {
        fun total(x0: Int): Int {
            var x = x0
            var result = 0
            while (x != 0) {
                result += x % 10
                x /= 10
            }
            return result
        }

        var elementSum = 0
        var digitSum = 0
        for (x in nums) {
            elementSum += x
            digitSum += total(x)
        }
        return abs(elementSum - digitSum)
    }
}
