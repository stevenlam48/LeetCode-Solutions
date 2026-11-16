package minimumswapstoavoidforbiddenvalues

// Time:  O(n)
// Space: O(1)

class Solution {
    fun minSwaps(nums: IntArray, forbidden: IntArray): Int {
        var majority = 0
        var voteCount = 0
        for (i in nums.indices) {
            if (nums[i] != forbidden[i]) {
                continue
            }
            if (voteCount == 0) {
                majority = nums[i]
            }
            if (nums[i] == majority) {
                ++voteCount
            } else {
                --voteCount
            }
        }

        var cnt = 0
        var cntM = 0
        var bal = 0
        for (i in nums.indices) {
            if (nums[i] != forbidden[i]) {
                if (nums[i] != majority && majority != forbidden[i]) {
                    ++bal
                }
                continue
            }
            ++cnt
            if (nums[i] != majority) {
                ++bal
            } else {
                --bal
                ++cntM
            }
        }
        return if (bal >= 0) maxOf(cntM, (cnt + 1) / 2) else -1
    }
}
