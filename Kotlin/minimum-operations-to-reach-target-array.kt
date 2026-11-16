package minimumoperationstoreachtargetarray

// Time:  O(n)
// Space: O(n)

// hash table
class Solution {
    fun minOperations(nums: IntArray, target: IntArray): Int {
        val result = HashSet<Int>()
        for (i in nums.indices) {
            if (nums[i] == target[i]) {
                continue
            }
            result.add(nums[i])
        }
        return result.size
    }
}
