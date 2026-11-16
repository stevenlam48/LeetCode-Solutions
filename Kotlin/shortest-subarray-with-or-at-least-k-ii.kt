package shortestsubarraywithoratleastkii

// Time:  O(nlogr) = O(n * 30)
// Space: O(logr) = O(30)

class Solution {
    fun minimumSubarrayLength(nums: IntArray, k: Int): Int {
        var total = 0
        for (x in nums) {
            total = total or x
        }
        if (total < k) {
            return -1
        }
        val bitLength = if (total == 0) 0 else 32 - Integer.numberOfLeadingZeros(total)
        val cnt = IntArray(bitLength)
        var result = nums.size
        var left = 0
        var curr = 0
        for (right in nums.indices) {
            curr = update(nums[right], 1, curr, cnt)
            while (left <= right && curr >= k) {
                result = minOf(result, right - left + 1)
                curr = update(nums[left], -1, curr, cnt)
                ++left
            }
        }
        return result
    }

    private fun update(x: Int, d: Int, current: Int, cnt: IntArray): Int {
        var curr = current
        var i = 0
        while ((1 shl i) <= x) {
            if (x and (1 shl i) != 0) {
                if (cnt[i] == 0) {
                    curr = curr xor (1 shl i)
                }
                cnt[i] += d
                if (cnt[i] == 0) {
                    curr = curr xor (1 shl i)
                }
            }
            ++i
        }
        return curr
    }
}
