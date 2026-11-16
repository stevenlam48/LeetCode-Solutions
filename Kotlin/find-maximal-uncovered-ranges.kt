package findmaximaluncoveredranges
// Time:  O(nlogn)
// Space: O(n)

class Solution {
    fun findMaximalUncoveredRanges(n: Int, ranges: Array<IntArray>): Array<IntArray> {
        ranges.sortWith(compareBy({ it[0] }, { it[1] }))
        val covered = mutableListOf(intArrayOf(-1, -1))
        for (r in ranges) {
            if (covered.last()[1] < r[0]) {
                covered.add(intArrayOf(r[0], r[1]))
                continue
            }
            covered.last()[1] = maxOf(covered.last()[1], r[1])
        }
        covered.add(intArrayOf(n, n))
        val result = mutableListOf<IntArray>()
        for (i in 1 until covered.size) {
            if (covered[i - 1][1] + 1 <= covered[i][0] - 1) {
                result.add(intArrayOf(covered[i - 1][1] + 1, covered[i][0] - 1))
            }
        }
        return result.toTypedArray()
    }
}
