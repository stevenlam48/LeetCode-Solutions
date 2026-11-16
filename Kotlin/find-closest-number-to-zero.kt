package findclosestnumbertozero

// Time:  O(n)
// Space: O(1)

// array
class Solution {
    fun findClosestNumber(nums: IntArray): Int {
        return nums.maxWithOrNull(compareBy<Int>({ -Math.abs(it) }, { it }))!!
    }
}
