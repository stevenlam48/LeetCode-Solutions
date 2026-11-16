package numberofsubarrayshavingevenproduct
// Time:  O(n)
// Space: O(1)

class Solution {
    fun evenProduct(nums: IntArray): Long {
        var result = (nums.size + 1).toLong() * nums.size / 2
        var count = 0
        for (value in nums) {
            count = if (value % 2 == 1) count + 1 else 0
            result -= count
        }
        return result
    }
}
