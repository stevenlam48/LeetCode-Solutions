package minimumimpossibleor

// Time:  O(logr)
// Space: O(1)

// hash table, bit manipulations
class Solution {
    fun minImpossibleOR(nums: IntArray): Int {
        val lookup = nums.toHashSet()
        var base = 1
        while (lookup.contains(base)) {
            base = base shl 1
        }
        return base
    }
}
