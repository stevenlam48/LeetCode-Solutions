package minimumoperationstomakearraysumdivisiblebyk

// Time:  O(n)
// Space: O(1)

class Solution {
    fun minOperations(nums: IntArray, k: Int): Int {
        return nums.sum() % k
    }
}
