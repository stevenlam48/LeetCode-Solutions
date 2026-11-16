package querykthsmallesttrimmednumber

// Time:  O(q + n * t)
// Space: O(t + n + q)

// radix sort
class Solution {
    fun smallestTrimmedNumbers(nums: List<String>, queries: Array<IntArray>): IntArray {
        var maxT = 0
        for (i in queries.indices) {
            maxT = maxOf(maxT, queries[i][1])
        }
        val lookup = Array(maxT + 1) { mutableListOf<IntArray>() }
        for (i in queries.indices) {
            lookup[queries[i][1]].add(intArrayOf(queries[i][0], i))
        }
        var idxs = IntArray(nums.size) { it }
        val result = IntArray(queries.size)
        for (l in 1..maxT) {
            val cnt = IntArray(10)
            for (i in idxs.indices) {
                val d = nums[idxs[i]][nums[idxs[i]].length - l] - '0'
                ++cnt[d]
            }
            for (d in 0 until 9) {
                cnt[d + 1] += cnt[d]
            }
            val newIdxs = IntArray(nums.size)
            for (i in idxs.size - 1 downTo 0) {
                val d = nums[idxs[i]][nums[idxs[i]].length - l] - '0'
                --cnt[d]
                newIdxs[cnt[d]] = idxs[i]
            }
            idxs = newIdxs
            for (q in lookup[l]) {
                result[q[1]] = idxs[q[0] - 1]
            }
        }
        return result
    }
}
