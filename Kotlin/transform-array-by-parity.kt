package transformarraybyparity

// Time:  O(n)
// Space: O(1)

class Solution {
    fun transformArray(nums: IntArray): IntArray {
        var cnt = 0
        for (i in nums.indices) {
            if (nums[i] % 2 != 0) {
                continue
            }
            nums[cnt++] = 0
        }
        while (cnt < nums.size) {
            nums[cnt] = 1
            ++cnt
        }
        return nums
    }
}
