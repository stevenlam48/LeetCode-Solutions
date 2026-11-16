package lexicographicallysmalleststringafteroperationswithconstraint

// Time:  O(n)
// Space: O(1)
class Solution {
    fun getSmallestString(s: String, k: Int): String {
        var remaining = k
        val chars = s.toCharArray()
        for (i in chars.indices) {
            val distance = minOf(chars[i] - 'a', 26 - (chars[i] - 'a'))
            chars[i] = if (distance <= remaining) {
                'a'
            } else {
                chars[i] - remaining
            }
            remaining -= minOf(distance, remaining)
            if (remaining == 0) {
                break
            }
        }
        return String(chars)
    }
}
