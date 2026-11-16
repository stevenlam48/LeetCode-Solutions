package minimumoperationstoexceedthresholdvaluei

// Time:  O(n)
// Space: O(1)

// array
class Solution {
    fun minOperations(nums: IntArray, k: Int): Int {
        return nums.count { it < k }
    }
}
