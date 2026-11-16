package maximumnumberofmatchingindicesafterrightshifts
// Time:  O(n^2)
// Space: O(1)

class Solution {
    fun maximumMatchingIndices(nums1: IntArray, nums2: IntArray): Int {
        var result = 0
        for (i in nums1.indices) {
            var cnt = 0
            for (j in nums2.indices) {
                if (nums2[j] == nums1[(i + j) % nums1.size]) {
                    ++cnt
                }
            }
            result = maxOf(result, cnt)
        }
        return result
    }
}
