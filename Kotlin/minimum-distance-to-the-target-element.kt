package minimumdistancetothetargetelement
// Time:  O(n)
// Space: O(1)

class Solution {
    fun getMinDistance(nums: IntArray, target: Int, start: Int): Int {
        var i = 0
        while (i < nums.size) {
            if ((start - i >= 0 && nums[start - i] == target) ||
                (start + i < nums.size && nums[start + i] == target)) {
                break
            }
            ++i
        }
        return i
    }
}
