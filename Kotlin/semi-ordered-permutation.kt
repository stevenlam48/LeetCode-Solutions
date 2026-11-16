package semiorderedpermutation

// Time:  O(n)
// Space: O(1)

class Solution {
    fun semiOrderedPermutation(nums: IntArray): Int {
        val i = nums.indexOf(1)
        val j = nums.indexOf(nums.size)
        return i + ((nums.size - 1) - j) - (if (i > j) 1 else 0)
    }
}
