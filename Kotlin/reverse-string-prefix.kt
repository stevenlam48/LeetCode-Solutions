package reversestringprefix
// Time:  O(n)
// Space: O(1)

class Solution {
    fun reversePrefix(s: String, k: Int): String {
        val chars = s.toCharArray()
        var left = 0
        var right = k - 1
        while (left < right) {
            val temp = chars[left]
            chars[left] = chars[right]
            chars[right] = temp
            ++left
            --right
        }
        return String(chars)
    }
}
