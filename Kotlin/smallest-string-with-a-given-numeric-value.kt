package smalleststringwithagivennumericvalue
// Time:  O(n)
// Space: O(1)

class Solution {
    fun getSmallestString(n: Int, k: Int): String {
        val maxDiff = 'z' - 'a'
        var remaining = k - n
        val result = CharArray(n) { 'a' }
        var i = n - 1
        while (i >= 0 && remaining > 0) {
            result[i] = 'a' + minOf(remaining, maxDiff)
            remaining -= minOf(remaining, maxDiff)
            --i
        }
        return String(result)
    }
}
