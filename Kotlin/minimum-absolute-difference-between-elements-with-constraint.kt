package minimumabsolutedifferencebetweenelementswithconstraint

import java.util.TreeSet

// Time:  O(nlogn)
// Space: O(n)

class Solution {
    fun minAbsoluteDifference(nums: IntArray, x: Int): Int {
        var result = Int.MAX_VALUE
        val bst = TreeSet<Int>()
        for (i in x until nums.size) {
            bst.add(nums[i - x])
            val it = bst.ceiling(nums[i])
            if (it != null) {
                result = minOf(result, it - nums[i])
            }
            val lo = bst.lower(nums[i])
            if (lo != null) {
                result = minOf(result, nums[i] - lo)
            }
        }
        return result
    }
}
