package makearraynondecreasing

// Time:  O(n)
// Space: O(1)

class Solution {
    fun maximumPossibleSize(nums: IntArray): Int {
        var result = 0
        var prev = 0
        for (x in nums) {
            if (prev <= x) {
                prev = x
                ++result
            }
        }
        return result
    }
}
