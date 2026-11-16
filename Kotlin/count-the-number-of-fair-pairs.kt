package countthenumberoffairpairs

// Time:  O(nlogn)
// Space: O(1)

// sort, two pointers
class Solution {
    fun countFairPairs(nums: IntArray, lower: Int, upper: Int): Long {
        val count = { x: Long ->
            var cnt = 0L
            var left = 0
            var right = nums.size - 1
            while (left < right) {
                if (nums[left].toLong() + nums[right] <= x) {
                    cnt += right - left
                    ++left
                } else {
                    --right
                }
            }
            cnt
        }

        nums.sort()
        return count(upper.toLong()) - count(lower.toLong() - 1)
    }
}
