package countstablesubarrays

// Time:  O(n + q)
// Space: O(n)

// prefix sum
class Solution {
    fun countStableSubarrays(nums: IntArray, queries: Array<IntArray>): LongArray {
        val count = { n: Long -> (n + 1) * n / 2 }

        val right = IntArray(nums.size) { it }
        for (i in nums.size - 2 downTo 0) {
            if (nums[i] <= nums[i + 1]) {
                right[i] = right[i + 1]
            }
        }
        val prefix = LongArray(nums.size + 1)
        var curr = 0
        for (i in nums.indices) {
            if (i - 1 >= 0 && nums[i - 1] > nums[i]) {
                curr = 0
            }
            ++curr
            prefix[i + 1] = prefix[i] + curr
        }
        val result = LongArray(queries.size)
        for (i in queries.indices) {
            val l = queries[i][0]
            val r = queries[i][1]
            val m = minOf(right[l], r)
            result[i] = count((m - l + 1).toLong()) + (prefix[r + 1] - prefix[m + 1])
        }
        return result
    }
}
