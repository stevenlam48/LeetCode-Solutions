package reversewordsinastringii
// Time:  O(n)
// Space: O(1)

class Solution {
    fun reverseWords(s: String): String {
        val chars = s.toCharArray()
        reverse(chars, 0, chars.size)
        var begin = 0
        for (end in 0..chars.size) {
            if (end == chars.size || chars[end] == ' ') {
                reverse(chars, begin, end)
                begin = end + 1
            }
        }
        return String(chars)
    }

    private fun reverse(chars: CharArray, begin: Int, end: Int) {
        var left = begin
        var right = end - 1
        while (left < right) {
            val temp = chars[left]
            chars[left++] = chars[right]
            chars[right--] = temp
        }
    }
}
