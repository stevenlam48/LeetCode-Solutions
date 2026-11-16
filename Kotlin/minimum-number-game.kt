package minimumnumbergame
// Time:  O(nlogn)
// Space: O(1)

class Solution {
    fun numberGame(nums: IntArray): IntArray {
        nums.sort()
        for (i in nums.indices step 2) {
            val tmp = nums[i]
            nums[i] = nums[i + 1]
            nums[i + 1] = tmp
        }
        return nums
    }
}
