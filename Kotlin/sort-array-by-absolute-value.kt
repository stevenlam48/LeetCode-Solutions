package sortarraybyabsolutevalue

import kotlin.math.abs

// Time:  O(n + r)
// Space: O(n + r)

class Solution {
    fun sortByAbsoluteValue(nums: IntArray): IntArray {
        var mx = 0
        for (x in nums) {
            mx = maxOf(mx, abs(x))
        }
        val lookup = Array(mx + 1) { ArrayList<Int>() }
        for (x in nums) {
            lookup[abs(x)].add(x)
        }
        val result = ArrayList<Int>()
        for (xs in lookup) {
            for (x in xs) {
                result.add(x)
            }
        }
        return result.toIntArray()
    }
}
