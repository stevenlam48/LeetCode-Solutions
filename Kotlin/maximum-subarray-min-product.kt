package maximumsubarrayminproduct

// Time:  O(n)
// Space: O(n)

class Solution {
    fun maxSumMinProduct(nums: IntArray): Int {
        val mod = 1_000_000_007
        val prefix = LongArray(nums.size + 1)
        for (i in nums.indices) {
            prefix[i + 1] = prefix[i] + nums[i]
        }
        val stack = mutableListOf(-1)
        var result = 0L
        for (i in 0..nums.size) {
            while (stack.last() != -1 && (i == nums.size || nums[stack.last()] >= nums[i])) {
                val j = stack.last()
                stack.removeAt(stack.lastIndex)
                result = maxOf(result, nums[j].toLong() * (prefix[i] - prefix[stack.last() + 1]))
            }
            stack.add(i)
        }
        return (result % mod).toInt()
    }
}
