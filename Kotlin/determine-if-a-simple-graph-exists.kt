package determineifasimplegraphexists

// Time:  O(nlogn)
// Space: O(1)

class Solution {
    fun simpleGraphExists(degrees: IntArray): Boolean {
        val total = degrees.sumOf { it.toLong() }
        if (total % 2 != 0L) {
            return false
        }
        degrees.sortDescending()
        var lhs = 0L
        var suffix1 = total
        var suffix2 = 0L
        var i = degrees.size - 1
        for (k in 1..degrees.size) {
            lhs += degrees[k - 1]
            suffix1 -= degrees[k - 1]
            while (i >= 0 && degrees[i] < k) {
                suffix2 += degrees[i]
                --i
            }
            val rhs = k.toLong() * (k - 1) +
                if (i - k + 1 > 0) {
                    (i - k + 1).toLong() * k + suffix2
                } else {
                    suffix1
                }
            if (lhs > rhs) {
                return false
            }
        }
        return true
    }
}
