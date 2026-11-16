package maximumsumofdistinctsubarrayswithlengthk
// Time:  O(n)
// Space: O(k)

class Solution {
    fun maximumSubarraySum(nums: IntArray, k: Int): Long {
        var result = 0L
        var left = 0
        var total = 0L
        val lookup = HashSet<Int>()
        for (right in nums.indices) {
            while (nums[right] in lookup || lookup.size == k) {
                lookup.remove(nums[left])
                total -= nums[left]
                ++left
            }
            lookup.add(nums[right])
            total += nums[right]
            if (lookup.size == k) {
                result = maxOf(result, total)
            }
        }
        return result
    }
}
