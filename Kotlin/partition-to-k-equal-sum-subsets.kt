package partitiontokequalsumsubsets

// Time:  O(n*2^n)
// Space: O(2^n)

class Solution {
    fun canPartitionKSubsets(nums: IntArray, k: Int): Boolean {
        val sum = nums.sum()
        if (sum % k != 0 || nums.max() > sum / k) {
            return false
        }
        val lookup = HashMap<Int, Boolean>()
        lookup[(1 shl nums.size) - 1] = true
        return dfs(nums, sum / k, 0, sum, lookup)
    }

    private fun dfs(
        nums: IntArray,
        target: Int,
        used: Int,
        todo: Int,
        lookup: HashMap<Int, Boolean>
    ): Boolean {
        if (used !in lookup) {
            val targ = (todo - 1) % target + 1
            for (i in nums.indices) {
                if (((used shr i) and 1) == 0 && nums[i] <= targ) {
                    if (dfs(nums, target, used or (1 shl i), todo - nums[i], lookup)) {
                        lookup[used] = true
                        break
                    }
                }
            }
        }
        return lookup[used] ?: false
    }
}
