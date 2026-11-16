package minimumoperationstomakearrayequaltotarget

// Time:  O(n)
// Space: O(1)

class Solution {
    fun minimumOperations(nums: IntArray, target: IntArray): Long {
        for (i in target.indices) {
            target[i] -= nums[i]
        }
        var result = 0L
        for (i in 0..target.size) {
            val current = if (i < target.size) target[i] else 0
            val previous = if (i - 1 >= 0) target[i - 1] else 0
            result += maxOf(current - previous, 0)
        }
        return result
    }
}
