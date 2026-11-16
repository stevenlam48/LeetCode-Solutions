package mergetwo2darraysbysummingvalues

// Time:  O(n)
// Space: O(1)

class Solution {
    fun mergeArrays(nums1: Array<IntArray>, nums2: Array<IntArray>): Array<IntArray> {
        val result = mutableListOf<IntArray>()
        var i = 0
        var j = 0
        while (i < nums1.size || j < nums2.size) {
            if (j == nums2.size || (i < nums1.size && nums1[i][0] < nums2[j][0])) {
                if (result.isNotEmpty() && result.last()[0] == nums1[i][0]) {
                    result.last()[1] += nums1[i][1]
                } else {
                    result.add(nums1[i].copyOf())
                }
                ++i
            } else {
                if (result.isNotEmpty() && result.last()[0] == nums2[j][0]) {
                    result.last()[1] += nums2[j][1]
                } else {
                    result.add(nums2[j].copyOf())
                }
                ++j
            }
        }
        return result.toTypedArray()
    }
}
