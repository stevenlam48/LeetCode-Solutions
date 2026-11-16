package missingnumber
// Time:  O(n)
// Space: O(1)

class Solution {
    fun missingNumber(nums: IntArray): Int {
        var num = 0
        for (i in nums.indices) {
            num = num xor nums[i] xor (i + 1)
        }
        return num
    }
}
