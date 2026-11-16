package maximumscoreofsplicedarray

// Time:  O(n)
// Space: O(1)

class Solution {
    fun maximumsSplicedArray(nums1: IntArray, nums2: IntArray): Int {
        fun modifiedKadane(a: IntArray, b: IntArray): Int {
            var result = 0
            var curr = 0
            for (i in a.indices) {
                curr = maxOf(curr + (b[i] - a[i]), 0)
                result = maxOf(result, curr)
            }
            return a.sum() + result
        }

        return maxOf(modifiedKadane(nums1, nums2), modifiedKadane(nums2, nums1))
    }
}
