package contiguousarray
// Time:  O(n)
// Space: O(n)

class Solution {
    fun findMaxLength(nums: IntArray): Int {
        var result = 0
        var count = 0
        val lookup = hashMapOf(0 to -1)
        for (i in nums.indices) {
            count += if (nums[i] == 1) 1 else -1
            if (count in lookup) {
                result = maxOf(result, i - lookup[count]!!)
            } else {
                lookup[count] = i
            }
        }
        return result
    }
}
