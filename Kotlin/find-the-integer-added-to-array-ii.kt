package findtheintegeraddedtoarrayii

// Time:  O(n)
// Space: O(n)

class Solution {
    fun minimumAddedInteger(nums1: IntArray, nums2: IntArray): Int {
        fun check(cnt2: Map<Int, Int>, cnt1: Map<Int, Int>): Boolean {
            val keys = HashSet<Int>()
            keys.addAll(cnt2.keys)
            keys.addAll(cnt1.keys)
            for (k in keys) {
                if ((cnt2[k] ?: 0) > (cnt1[k] ?: 0)) {
                    return false
                }
            }
            return true
        }

        for (i in 0 until minOf(3, nums1.size)) {
            var maxIdx = i
            for (j in i + 1 until nums1.size) {
                if (nums1[j] > nums1[maxIdx]) {
                    maxIdx = j
                }
            }
            val t = nums1[i]
            nums1[i] = nums1[maxIdx]
            nums1[maxIdx] = t
        }
        val cnt2 = HashMap<Int, Int>()
        for (x in nums2) {
            cnt2[x] = (cnt2[x] ?: 0) + 1
        }
        val mx = nums2.max()
        for (i in 0 until 3) {
            val d = mx - nums1[i]
            val cnt1 = HashMap<Int, Int>()
            for (x in nums1) {
                cnt1[x + d] = (cnt1[x + d] ?: 0) + 1
            }
            if (check(cnt2, cnt1)) {
                return d
            }
        }
        return -1
    }
}
