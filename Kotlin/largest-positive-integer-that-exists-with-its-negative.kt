package largestpositiveintegerthatexistswithitsnegative

// Time:  O(n)
// Space: O(n)

// hash table
class Solution {
    fun findMaxK(nums: IntArray): Int {
        val lookup = nums.toHashSet()
        var result = -1
        for (x in lookup) {
            if (x > result && lookup.contains(-x)) {
                result = x
            }
        }
        return result
    }
}
