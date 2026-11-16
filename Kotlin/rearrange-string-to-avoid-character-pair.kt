package rearrangestringtoavoidcharacterpair

// Time:  O(n)
// Space: O(1)

class Solution {
    fun rearrangeString(s: String, x: Char, y: Char): String {
        val chars = s.toCharArray()
        var left = 0
        var right = chars.size - 1
        while (left < right) {
            if (chars[left] != x) {
                ++left
                continue
            }
            if (chars[right] != y) {
                --right
                continue
            }
            val tmp = chars[left]
            chars[left] = chars[right]
            chars[right] = tmp
            ++left
            --right
        }
        return String(chars)
    }
}
