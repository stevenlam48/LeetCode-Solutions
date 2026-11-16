package minimumtimetoactivatestring

// Time:  O(n)
// Space: O(n)

class Solution {
    fun minTime(s: String, order: IntArray, k: Int): Int {
        val n = s.length
        val left = IntArray(n) { it - 1 }
        val right = IntArray(n) { it + 1 }
        var cnt = (n + 1).toLong() * n / 2
        if (cnt < k) {
            return -1
        }
        var t = order.size - 1
        while (t >= 0) {
            val i = order[t]
            val l = left[i]
            val r = right[i]
            cnt -= (i - l).toLong() * (r - i)
            if (cnt < k) {
                break
            }
            if (l >= 0) {
                right[l] = r
            }
            if (r < n) {
                left[r] = l
            }
            --t
        }
        return t
    }
}
