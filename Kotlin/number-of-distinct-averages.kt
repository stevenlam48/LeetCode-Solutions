package numberofdistinctaverages

// Time:  O(nlogn)
// Space: O(n)

class Solution {
    fun distinctAverages(nums: IntArray): Int {
        nums.sort()
        val lookup = HashSet<Int>()
        var left = 0
        var right = nums.size - 1
        while (left < right) {
            lookup.add(nums[left] + nums[right])
            ++left
            --right
        }
        return lookup.size
    }
}
