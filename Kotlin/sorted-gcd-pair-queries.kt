package sortedgcdpairqueries

// Time:  O(rlogr + qlogr), r = max(nums)
// Space: O(r)

class Solution {
    fun gcdValues(nums: IntArray, queries: LongArray): IntArray {
        val cnt1 = HashMap<Int, Int>()
        for (x in nums) {
            cnt1[x] = (cnt1[x] ?: 0) + 1
        }
        val cnt2 = LongArray(nums.max() + 1)
        for (g in cnt2.size - 1 downTo 1) {
            var c = 0L
            var ng = g
            while (ng < cnt2.size) {
                c += (cnt1[ng] ?: 0).toLong()
                ng += g
            }
            cnt2[g] = c * (c - 1) / 2
            ng = g + g
            while (ng < cnt2.size) {
                cnt2[g] -= cnt2[ng]
                ng += g
            }
        }
        val prefix = LongArray(cnt2.size + 1)
        for (i in 0 until prefix.size - 1) {
            prefix[i + 1] += prefix[i] + cnt2[i]
        }
        val result = IntArray(queries.size)
        for (i in queries.indices) {
            var lo = 0
            var hi = prefix.size
            while (lo < hi) {
                val mid = lo + (hi - lo) / 2
                if (prefix[mid] <= queries[i]) {
                    lo = mid + 1
                } else {
                    hi = mid
                }
            }
            result[i] = lo - 1
        }
        return result
    }
}
