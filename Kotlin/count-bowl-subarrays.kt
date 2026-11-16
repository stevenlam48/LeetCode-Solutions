package countbowlsubarrays

// Time:  O(n)
// Space: O(n)

class Solution {
    fun bowlSubarrays(nums: IntArray): Long {
        var result = 0L
        val stk = ArrayList<Int>()
        for (i in nums.indices) {
            while (stk.isNotEmpty() && nums[stk.last()] < nums[i]) {
                stk.removeAt(stk.lastIndex)
                if (stk.isNotEmpty()) {
                    ++result
                }
            }
            stk.add(i)
        }
        return result
    }
}
