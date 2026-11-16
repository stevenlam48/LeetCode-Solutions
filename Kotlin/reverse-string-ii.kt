package reversestringii
// Time:  O(n)
// Space: O(1)

class Solution {
    fun reverseStr(s: String, k: Int): String {
        val chars = s.toCharArray()
        var left = 0
        while (left < chars.size) {
            var i = left
            var j = minOf(left + k - 1, chars.size - 1)
            while (i < j) {
                val temp = chars[i]
                chars[i] = chars[j]
                chars[j] = temp
                ++i
                --j
            }
            left += 2 * k
        }
        return String(chars)
    }
}
