package counthillsandvalleysinanarray

// Time:  O(n)
// Space: O(1)

class Solution {
    fun countHillValley(nums: IntArray): Int {
        var result = 0
        var inc = -1
        for (i in 0 until nums.size - 1) {
            if (nums[i] < nums[i + 1]) {
                result += if (inc == 0) 1 else 0
                inc = 1
            } else if (nums[i] > nums[i + 1]) {
                result += if (inc == 1) 1 else 0
                inc = 0
            }
        }
        return result
    }
}
