package matchstickstosquare

// Time:  O(n * s * 2^n), s is the number of subset of which sum equals to side length.
// Space: O(n * (2^n + s))

class Solution {
    fun makesquare(nums: IntArray): Boolean {
        val sum = nums.sum()
        if (sum % 4 != 0) {
            return false
        }

        val sideLen = sum / 4
        val all = (1 shl nums.size) - 1
        val usedSubsets = mutableListOf<Int>()
        val validHalfSubsets = BooleanArray(1 shl nums.size)

        for (subset in 0..all) {
            var subsetSum = 0
            for (i in nums.indices) {
                if (subset and (1 shl i) != 0) {
                    subsetSum += nums[i]
                }
            }
            if (subsetSum == sideLen) {
                for (usedSubset in usedSubsets) {
                    if (usedSubset and subset == 0) {
                        val validHalfSubset = usedSubset or subset
                        validHalfSubsets[validHalfSubset] = true
                        if (validHalfSubsets[all xor validHalfSubset]) {
                            return true
                        }
                    }
                }
                usedSubsets.add(subset)
            }
        }
        return false
    }
}
