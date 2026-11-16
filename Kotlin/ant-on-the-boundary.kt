package antontheboundary

// Time:  O(n)
// Space: O(1)

class Solution {
    fun returnToBoundaryCount(nums: IntArray): Int {
        var result = 0
        var curr = 0
        for (x in nums) {
            curr += x
            if (curr == 0) {
                ++result
            }
        }
        return result
    }
}
