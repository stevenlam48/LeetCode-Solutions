package findminimumoperationstomakeallelementsdivisiblebythree

// Time:  O(n)
// Space: O(1)

class Solution {
    fun minimumOperations(nums: IntArray): Int {
        var result = 0
        for (x in nums) {
            if (x % 3 != 0) {
                ++result
            }
        }
        return result
    }
}
