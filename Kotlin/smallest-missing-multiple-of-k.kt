package smallestmissingmultipleofk

// Time:  O(n)
// Space: O(n)

class Solution {
    fun missingMultiple(nums: IntArray, k: Int): Int {
        val lookup = nums.toHashSet()
        for (i in 1..lookup.size) {
            if (!lookup.contains(i * k)) {
                return i * k
            }
        }
        return (lookup.size + 1) * k
    }
}
