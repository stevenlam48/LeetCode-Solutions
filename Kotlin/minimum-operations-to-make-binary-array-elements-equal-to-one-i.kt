package minimumoperationstomakebinaryarrayelementsequaltoonei

// Time:  O(n)
// Space: O(1)

class Solution {
    fun minOperations(nums: IntArray): Int {
        var result = 0
        for (i in 0 until nums.size - 2) {
            if (nums[i] != 0) {
                continue
            }
            nums[i + 1] = nums[i + 1] xor 1
            nums[i + 2] = nums[i + 2] xor 1
            ++result
        }
        return if (nums[nums.size - 2] == nums[nums.size - 1] && nums[nums.size - 1] == 1) {
            result
        } else {
            -1
        }
    }
}
