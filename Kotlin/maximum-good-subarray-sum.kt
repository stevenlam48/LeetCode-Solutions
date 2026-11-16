package maximumgoodsubarraysum

// Time:  O(n)
// Space: O(n)

class Solution {
    fun maximumSubarraySum(nums: IntArray, k: Int): Long {
        val prefix = HashMap<Int, Long>()
        var result = Long.MIN_VALUE
        var curr = 0L
        for (x in nums) {
            prefix[x] = minOf(prefix[x] ?: Long.MAX_VALUE, curr)
            curr += x
            prefix[x - k]?.let { result = maxOf(result, curr - it) }
            prefix[x + k]?.let { result = maxOf(result, curr - it) }
        }
        return if (result != Long.MIN_VALUE) result else 0L
    }
}
