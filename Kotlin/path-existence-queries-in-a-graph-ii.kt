package pathexistencequeriesinagraphii

// Time:  O((n + q) * logn)
// Space: O(nlogn)

class Solution {
    fun pathExistenceQueries(
        n: Int,
        nums: IntArray,
        maxDiff: Int,
        queries: Array<IntArray>
    ): IntArray {
        fun bitLength(x: Int): Int = if (x != 0) 32 - x.countLeadingZeroBits() else 0
        fun ceilLog2X(x: Int): Int = bitLength(x - 1)

        val sortedI = Array(n) { it }
        sortedI.sortWith(compareBy { nums[it] })
        val iToIdx = IntArray(n)
        for (idx in 0 until n) {
            iToIdx[sortedI[idx]] = idx
        }
        val prefix = IntArray(n)
        for (i in 0 until n - 1) {
            prefix[i + 1] = prefix[i] + if (nums[sortedI[i + 1]] - nums[sortedI[i]] <= maxDiff) 0 else 1
        }
        val p = Array(ceilLog2X(n - 1) + 1) { IntArray(n) { n - 1 } }
        var left = 0
        for (right in 0 until n) {
            while (nums[sortedI[right]] - nums[sortedI[left]] > maxDiff) {
                p[0][left] = right - 1
                ++left
            }
        }
        for (i in 0 until p.size - 1) {
            for (j in 0 until n) {
                p[i + 1][j] = p[i][p[i][j]]
            }
        }
        val result = IntArray(queries.size) { -1 }
        for (idx in queries.indices) {
            var i = queries[idx][0]
            var j = queries[idx][1]
            if (i == j) {
                result[idx] = 0
                continue
            }
            if (prefix[iToIdx[i]] != prefix[iToIdx[j]]) {
                continue
            }
            if (iToIdx[i] > iToIdx[j]) {
                val tmp = i
                i = j
                j = tmp
            }
            var curr = iToIdx[i]
            var l = 0
            for (k in p.size - 1 downTo 0) {
                if (p[k][curr] < iToIdx[j]) {
                    curr = p[k][curr]
                    l += 1 shl k
                }
            }
            result[idx] = l + 1
        }
        return result
    }
}
