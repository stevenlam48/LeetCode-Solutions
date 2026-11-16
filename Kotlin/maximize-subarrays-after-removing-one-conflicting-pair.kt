package maximizesubarraysafterremovingoneconflictingpair

// Time:  O(n + m)
// Space: O(n + m)

class Solution {
    fun maxSubarrays(n: Int, conflictingPairs: Array<IntArray>): Long {
        val right = Array(n) { mutableListOf<Long>() }
        for (p in conflictingPairs) {
            var l = p[0] - 1
            var r = p[1] - 1
            if (l > r) {
                val tmp = l
                l = r
                r = tmp
            }
            right[r].add(l.toLong())
        }
        var result = 0L
        val top2 = longArrayOf(-1L, -1L)
        val cnt = LongArray(n)
        for (r in 0 until n) {
            for (left in right[r]) {
                var l = left
                for (i in top2.indices) {
                    if (l > top2[i]) {
                        val tmp = l
                        l = top2[i]
                        top2[i] = tmp
                    }
                }
            }
            result += r - top2[0]
            if (top2[0] != -1L) {
                cnt[top2[0].toInt()] += top2[0] - top2[1]
            }
        }
        return result + cnt.maxOrNull()!!
    }
}
