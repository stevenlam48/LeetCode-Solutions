package maximumsumofalmostuniquesubarray
// Time:  O(n)
// Space: O(n)

class Solution {
    fun maxSum(nums: IntArray, m: Int, k: Int): Long {
        val lookup = HashMap<Int, Int>()
        var result = 0L
        var curr = 0L
        var left = 0
        for (right in nums.indices) {
            curr += nums[right]
            lookup[nums[right]] = (lookup[nums[right]] ?: 0) + 1
            if (right - left + 1 == k + 1) {
                val frequency = lookup[nums[left]]!! - 1
                if (frequency == 0) {
                    lookup.remove(nums[left])
                } else {
                    lookup[nums[left]] = frequency
                }
                curr -= nums[left]
                ++left
            }
            if (right - left + 1 == k && lookup.size >= m) {
                result = maxOf(result, curr)
            }
        }
        return result
    }
}
