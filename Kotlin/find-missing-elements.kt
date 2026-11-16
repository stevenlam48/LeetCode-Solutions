package findmissingelements

// Time:  O(n + r)
// Space: O(n)

class Solution {
    fun findMissingElements(nums: IntArray): IntArray {
        val lookup = nums.toHashSet()
        val result = mutableListOf<Int>()
        val mn = nums.minOrNull()!!
        val mx = nums.maxOrNull()!!
        for (x in mn + 1 until mx) {
            if (x !in lookup) {
                result.add(x)
            }
        }
        return result.toIntArray()
    }
}
