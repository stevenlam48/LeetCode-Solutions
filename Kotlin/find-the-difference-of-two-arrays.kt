package findthedifferenceoftwoarrays

// Time:  O(n)
// Space: O(n)
class Solution {
    fun findDifference(nums1: IntArray, nums2: IntArray): Array<IntArray> {
        val result = Array(2) { mutableListOf<Int>() }
        val lookup = arrayOf(nums1.toHashSet(), nums2.toHashSet())
        for (i in 0 until 2) {
            for (x in lookup[i]) {
                if (x !in lookup[1 - i]) {
                    result[i].add(x)
                }
            }
        }
        return arrayOf(result[0].toIntArray(), result[1].toIntArray())
    }
}
