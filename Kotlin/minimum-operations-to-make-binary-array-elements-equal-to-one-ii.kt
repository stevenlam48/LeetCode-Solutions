package minimumoperationstomakebinaryarrayelementsequaltooneii

// Time:  O(n)
// Space: O(1)

class Solution {
    fun minOperations(nums: IntArray): Int {
        var result = 0
        for (x in nums) {
            if ((x xor (result and 1)) != 0) {
                continue
            }
            ++result
        }
        return result
    }
}
