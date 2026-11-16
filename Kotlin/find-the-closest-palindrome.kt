package findtheclosestpalindrome

import kotlin.math.abs
import kotlin.math.pow

// Time:  O(l)
// Space: O(l)
class Solution {
    fun nearestPalindromic(n: String): String {
        val l = n.length
        val candidates = hashSetOf<Long>()
        candidates.add(10.0.pow(l).toLong() + 1)
        candidates.add(10.0.pow(l - 1).toLong() - 1)
        val prefix = n.substring(0, (l + 1) / 2).toLong()
        for (i in -1L..1L) {
            val p = (prefix + i).toString()
            val pp = p + p.reversed().drop(l % 2)
            candidates.add(pp.toLong())
        }
        val num = n.toLong()
        var closestVal = Long.MAX_VALUE
        candidates.remove(num)
        for (value in candidates) {
            if (abs(value - num) < abs(closestVal - num)) {
                closestVal = value
            } else if (abs(value - num) == abs(closestVal - num)) {
                closestVal = minOf(closestVal, value)
            }
        }
        return closestVal.toString()
    }
}
