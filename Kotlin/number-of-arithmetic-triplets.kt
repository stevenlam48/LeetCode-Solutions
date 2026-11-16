package numberofarithmetictriplets

// Time:  O(n)
// Space: O(n)

class Solution {
    fun arithmeticTriplets(nums: IntArray, diff: Int): Int {
        val lookup = nums.toHashSet()
        var total = 0
        for (x in nums) {
            total += (if (x - diff in lookup) 1 else 0) * (if (x - 2 * diff in lookup) 1 else 0)
        }
        return total
    }
}
