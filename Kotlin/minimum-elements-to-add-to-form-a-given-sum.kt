package minimumelementstoaddtoformagivensum

// Time:  O(n)
// Space: O(1)

class Solution {
    fun minElements(nums: IntArray, limit: Int, goal: Int): Int {
        var total = 0L
        for (x in nums) {
            total += x
        }
        return ((kotlin.math.abs(total - goal) + (limit - 1)) / limit).toInt()
    }
}
