package reductionoperationstomakethearrayelementsequal

// Time:  O(nlogn)
// Space: O(1)

class Solution {
    fun reductionOperations(nums: IntArray): Int {
        nums.sort()
        var result = 0
        var curr = 0
        for (i in 1 until nums.size) {
            if (nums[i - 1] < nums[i]) {
                ++curr
            }
            result += curr
        }
        return result
    }
}
