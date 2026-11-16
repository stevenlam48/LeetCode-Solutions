package houserobber
// Time:  O(n)
// Space: O(1)

class Solution {
    fun rob(nums: IntArray): Int {
        var last = 0
        var result = 0
        for (i in nums) {
            val tmp = result
            result = maxOf(last + i, result)
            last = tmp
        }
        return result
    }
}
