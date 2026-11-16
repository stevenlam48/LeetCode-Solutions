package minimumnumberofincreasingsubsequencetoberemoved

// Time:  O(nlogn)
// Space: O(n)

// binary search, longest increasing subsequence, lis
class Solution {
    fun minOperations(nums: IntArray): Int {
        val result = ArrayList<Int>()
        for (x in nums) {
            val v = -x
            var lo = 0
            var hi = result.size
            while (lo < hi) {
                val mid = (lo + hi) ushr 1
                if (result[mid] <= v) {
                    lo = mid + 1
                } else {
                    hi = mid
                }
            }
            if (lo == result.size) {
                result.add(v)
            } else {
                result[lo] = v
            }
        }
        return result.size
    }
}
