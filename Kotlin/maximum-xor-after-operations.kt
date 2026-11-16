package maximumxorafteroperations

// Time:  O(n)
// Space: O(1)

class Solution {
    fun maximumXOR(nums: IntArray): Int {
        var result = 0
        for (x in nums) {
            result = result or x
        }
        return result
    }
}
