package maximizefixedpointsafterdeletions

// Time:  O(nlogn)
// Space: O(n)

// sort, binary search, longest increasing subsequence, lis
class Solution {
    fun maxFixedPoints(nums: IntArray): Int {
        val pairs = ArrayList<IntArray>()
        for (i in nums.indices) {
            if (i - nums[i] >= 0) {
                pairs.add(intArrayOf(i - nums[i], nums[i]))
            }
        }
        pairs.sortWith(compareBy({ it[0] }, { it[1] }))

        val result = ArrayList<Int>()
        for (p in pairs) {
            val x = p[1]
            var lo = 0
            var hi = result.size
            while (lo < hi) {
                val mid = (lo + hi) / 2
                if (result[mid] < x) {
                    lo = mid + 1
                } else {
                    hi = mid
                }
            }
            if (lo == result.size) {
                result.add(x)
            } else {
                result[lo] = x
            }
        }
        return result.size
    }
}
