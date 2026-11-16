package longestsubarraydivisiblebykwithatmostonenegationi
// Time:  O(n + k^2)
// Space: O(k)

class Solution {
    fun longestSubarray(nums: IntArray, k: Int): Int {
        val lookup = mutableListOf(0)
        val left = IntArray(k) { -1 }
        left[0] = 0
        val indices = IntArray(k)
        val minimum = IntArray(k) { Int.MAX_VALUE }
        var prefix = 0
        var result = 0
        for (right in nums.indices) {
            val x = (nums[right] % k + k) % k
            val v = 2 * x % k
            for (i in indices[v] until lookup.size) {
                val residue = (lookup[i] + v) % k
                minimum[residue] = minOf(minimum[residue], left[lookup[i]])
            }
            indices[v] = lookup.size
            prefix = (prefix + x) % k
            if (left[prefix] != -1) {
                result = maxOf(result, right - left[prefix] + 1)
            } else {
                lookup.add(prefix)
                left[prefix] = right + 1
            }
            if (minimum[prefix] != Int.MAX_VALUE) {
                result = maxOf(result, right - minimum[prefix] + 1)
            }
        }
        return result
    }
}
