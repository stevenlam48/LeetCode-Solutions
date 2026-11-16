package maximumnumberofintegerstochoosefromarangei
// Time:  O(b)
// Space: O(b)

import kotlin.math.sqrt

class Solution {
    fun maxCount(banned: IntArray, n: Int, maxSum: Long): Int {
        val k = minOf((((-1 + sqrt((1 + 8 * maxSum).toDouble())) / 2).toInt()), n)
        var total = (k + 1).toLong() * k / 2
        var result = k
        val lookup = banned.toHashSet()
        for (x in lookup) {
            if (x <= k) {
                total -= x
                --result
            }
        }
        for (i in k + 1..n) {
            if (lookup.contains(i)) {
                continue
            }
            if (total + i > maxSum) {
                break
            }
            total += i
            ++result
        }
        return result
    }
}
