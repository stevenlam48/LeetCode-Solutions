package numberofcenteredsubarrays
// Time:  O(n^2)
// Space: O(n)

class Solution {
    fun centeredSubarrays(nums: IntArray): Int {
        var result = 0
        for (i in nums.indices) {
            val lookup = HashSet<Long>()
            var total = 0L
            for (j in i until nums.size) {
                lookup.add(nums[j].toLong())
                total += nums[j]
                if (lookup.contains(total)) {
                    ++result
                }
            }
        }
        return result
    }
}
