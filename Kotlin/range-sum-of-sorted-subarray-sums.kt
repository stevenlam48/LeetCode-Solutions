package rangesumofsortedsubarraysums

// Time:  O(nlog(sum(nums)))
// Space: O(n)

// binary search + sliding window solution
class Solution {
    fun rangeSum(nums: IntArray, n: Int, left: Int, right: Int): Int {
        val prefix = LongArray(nums.size)
        for (i in nums.indices) {
            prefix[i] = nums[i].toLong()
        }
        for (i in 0 until nums.size - 1) {
            prefix[i + 1] += prefix[i]
        }
        val min = nums.minOrNull()!!.toLong()
        val max = nums.fold(0L) { acc, v -> acc + v }
        return ((sumLessOrEqualTo(prefix, nums, min, max, right.toLong()) -
                sumLessOrEqualTo(prefix, nums, min, max, (left - 1).toLong())) % MOD).toInt()
    }

    private fun sumLessOrEqualTo(prefix: LongArray, nums: IntArray,
                                 left0: Long, right0: Long, target: Long): Long {
        var left = left0
        var right = right0
        while (left <= right) {
            val mid = left + (right - left) / 2
            if (countUntil(nums, mid) >= target) {
                right = mid - 1
            } else {
                left = mid + 1
            }
        }
        return sumUntil(nums, prefix, left) - left * (countUntil(nums, left) - target)
    }

    private fun countUntil(nums: IntArray, target: Long): Long {
        var result = 0L
        var curr = 0L
        var left = 0
        for (right in nums.indices) {
            curr += nums[right]
            while (curr > target) {
                curr -= nums[left]
                ++left
            }
            result += right - left + 1
        }
        return result
    }

    private fun sumUntil(nums: IntArray, prefix: LongArray, target: Long): Long {
        var result = 0L
        var curr = 0L
        var total = 0L
        var left = 0
        for (right in nums.indices) {
            curr += nums[right]
            total += nums[right].toLong() * (right - left + 1)
            while (curr > target) {
                curr -= nums[left]
                total -= prefix[right] - (if (left - 1 >= 0) prefix[left - 1] else 0L)
                ++left
            }
            result += total
        }
        return result
    }

    companion object {
        private const val MOD = 1000000007L
    }
}
