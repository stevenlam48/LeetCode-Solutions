package minimumsumofvaluesbydividingarray

// Time:  O(n * m * logr), r = max(nums)
// Space: O(n + logr)

class Solution {
    fun minimumValueSum(nums: IntArray, andValues: IntArray): Int {
        val inf = Int.MAX_VALUE
        val bitLength = { x: Int ->
            (if (x != 0) 31 - x.countLeadingZeroBits() else -1) + 1
        }
        val l = bitLength(nums.max())
        val update = { cnt: IntArray, x: Int, d: Int ->
            for (i in 0 until l) {
                if ((x and (1 shl i)) != 0) {
                    cnt[i] += d
                }
            }
        }
        val mask = { cnt: IntArray, length: Int ->
            var result = 0
            for (i in 0 until l) {
                if (cnt[i] == length) {
                    result = result or (1 shl i)
                }
            }
            result
        }
        var dp = IntArray(nums.size + 1) { inf }
        dp[0] = 0
        for (j in andValues.indices) {
            val newDp = IntArray(dp.size) { inf }
            val cnt = IntArray(l)
            val lengths = IntArray(dp.size)
            val dq = ArrayDeque<Int>()
            var left = j
            var idx = j
            for (right in j until nums.size) {
                update(cnt, nums[right], 1)
                if (mask(cnt, right - left + 1) <= andValues[j]) {
                    while (left <= right && mask(cnt, right - left + 1) <= andValues[j]) {
                        update(cnt, nums[left], -1)
                        ++left
                    }
                    --left
                    update(cnt, nums[left], 1)
                }
                if ((andValues[j] and nums[right]) == andValues[j]) {
                    lengths[right + 1] = lengths[right] + 1
                }
                if (mask(cnt, right - left + 1) != andValues[j]) {
                    continue
                }
                while (idx <= left) {
                    while (dq.isNotEmpty() && dp[dq.last()] >= dp[idx]) {
                        dq.removeLast()
                    }
                    dq.addLast(idx)
                    ++idx
                }
                while (dq.isNotEmpty() && dq.first() < left - lengths[left]) {
                    dq.removeFirst()
                }
                if (dq.isNotEmpty() && dp[dq.first()] != inf) {
                    newDp[right + 1] = dp[dq.first()] + nums[right]
                }
            }
            dp = newDp
        }
        return if (dp.last() != inf) dp.last() else -1
    }
}
