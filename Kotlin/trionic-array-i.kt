package trionicarrayi
// Time:  O(n)
// Space: O(1)

class Solution {
    fun isTrionic(nums: IntArray): Boolean {
        var p = 0
        while (p + 1 < nums.size && nums[p] < nums[p + 1]) {
            ++p
        }
        var q = p
        while (q + 1 < nums.size && nums[q] > nums[q + 1]) {
            ++q
        }
        var i = q
        while (i + 1 < nums.size && nums[i] < nums[i + 1]) {
            ++i
        }
        return 0 < p && p < q && q < i && i == nums.size - 1
    }
}
