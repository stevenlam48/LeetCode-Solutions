package maximumnumberthatsumofthepricesislessthanorequaltok

// Time:  O(max(logk, x) * log((logk) / x))
// Space: O((logk) / x)

class Solution {
    fun findMaximumNumber(k0: Long, x: Int): Long {
        var k = k0
        var result = 0L
        var prefixCnt = 0L
        val lookup = ArrayList<Long>()
        lookup.add(0)
        var i = 0
        while ((lookup.last() shl x) + (1L shl (i + x - 1)) <= k0) {
            lookup.add((lookup.last() shl x) + (1L shl (i + x - 1)))
            i += x
        }

        while (k >= prefixCnt) {
            var left = 1L
            var right = (lookup.size - 1).toLong()
            while (left <= right) {
                val mid = left + (right - left) / 2
                val count = (prefixCnt shl (x * mid.toInt())) + lookup[mid.toInt()]
                if (count <= k) {
                    left = mid + 1
                } else {
                    right = mid - 1
                }
            }
            val l = right.toInt()
            var cnt = (prefixCnt shl (x * l)) + lookup[l]
            var idx = x * l
            val c = minOf(if (cnt != 0L) (63 - java.lang.Long.numberOfLeadingZeros(k / cnt)).toInt() else x - 1, x - 1)
            cnt = cnt shl c
            idx += c
            k -= cnt
            result += 1L shl idx
            if ((idx + 1) % x == 0) {
                ++prefixCnt
            }
        }
        return result - 1
    }
}
