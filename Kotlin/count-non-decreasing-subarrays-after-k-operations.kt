package countnondecreasingsubarraysafterkoperations

// Time:  O(n)
// Space: O(n)

// mono deque, two pointers, sliding window
class Solution {
    fun countNonDecreasingSubarrays(nums: IntArray, k: Int): Long {
        var result = 0L
        var cnt = 0L
        val dq = ArrayDeque<Int>()
        var right = nums.size - 1
        for (left in nums.size - 1 downTo 0) {
            while (dq.isNotEmpty() && nums[dq.last()] < nums[left]) {
                val l = dq.removeLast().toLong()
                val r = if (dq.isNotEmpty()) dq.last().toLong() - 1 else right.toLong()
                cnt += (r - l + 1) * (nums[left] - nums[l.toInt()])
            }
            dq.addLast(left)
            while (cnt > k.toLong()) {
                cnt -= nums[dq.first()] - nums[right]
                if (dq.first() == right) {
                    dq.removeFirst()
                }
                --right
            }
            result += right - left + 1
        }
        return result
    }
}
