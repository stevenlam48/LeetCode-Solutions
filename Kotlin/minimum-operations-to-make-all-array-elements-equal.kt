package minimumoperationstomakeallarrayelementsequal

// Time:  O(nlogn + qlogn)
// Space: O(n)

class Solution {
    fun minOperations(nums: IntArray, queries: IntArray): LongArray {
        nums.sort()
        val prefix = LongArray(nums.size + 1)
        for (i in nums.indices) {
            prefix[i + 1] = prefix[i] + nums[i]
        }
        val result = LongArray(queries.size)
        for (i in queries.indices) {
            val q = queries[i].toLong()
            var left = 0
            var right = nums.size
            while (left < right) {
                val mid = (left + right) ushr 1
                if (nums[mid].toLong() < q) {
                    left = mid + 1
                } else {
                    right = mid
                }
            }
            val j = left
            result[i] = (q * j - prefix[j]) +
                ((prefix[prefix.lastIndex] - prefix[j]) - q * (nums.size - j))
        }
        return result
    }
}
