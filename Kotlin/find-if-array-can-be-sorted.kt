package findifarraycanbesorted

// Time:  O(n)
// Space: O(1)

// sort
class Solution {
    fun canSortArray(nums: IntArray): Boolean {
        var left = 0
        var mx = 0
        for (right in nums.indices) {
            if (right + 1 != nums.size && Integer.bitCount(nums[right + 1]) == Integer.bitCount(nums[right])) {
                continue
            }
            if (mx > (left..right).minOf { nums[it] }) {
                return false
            }
            mx = (left..right).maxOf { nums[it] }
            left = right + 1
        }
        return true
    }
}
