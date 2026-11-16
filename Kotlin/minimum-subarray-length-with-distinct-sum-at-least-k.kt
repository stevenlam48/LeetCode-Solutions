package minimumsubarraylengthwithdistinctsumatleastk

// Time:  O(n)
// Space: O(n)

import kotlin.math.min

class Solution {
    fun minLength(nums: IntArray, k: Int): Int {
        var result = Int.MAX_VALUE
        val cnt = HashMap<Int, Int>()
        var left = 0
        var curr = 0
        for (right in nums.indices) {
            val count = cnt.getOrDefault(nums[right], 0) + 1
            cnt[nums[right]] = count
            if (count == 1) {
                curr += nums[right]
            }
            while (curr >= k) {
                result = min(result, right - left + 1)
                val leftCount = cnt[nums[left]]!!
                cnt[nums[left]] = leftCount - 1
                if (leftCount == 1) {
                    curr -= nums[left]
                }
                ++left
            }
        }
        return if (result != Int.MAX_VALUE) result else -1
    }
}
