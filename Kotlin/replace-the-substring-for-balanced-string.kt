package replacethesubstringforbalancedstring

// Time:  O(n)
// Space: O(1)

class Solution {
    fun balancedString(s: String): Int {
        val count = IntArray(128)
        for (c in s) {
            ++count[c.code]
        }
        var result = s.length
        var left = 0
        for (right in s.indices) {
            --count[s[right].code]
            while (left < s.length && count.all { it <= s.length / 4 }) {
                result = minOf(result, right - left + 1)
                ++count[s[left++].code]
            }
        }
        return result
    }
}
