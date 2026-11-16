package reversewordsinastringiii
// Time:  O(n)
// Space: O(1)

class Solution {
    fun reverseWords(s: String): String {
        val chars = s.toCharArray()
        var begin = 0
        for (end in 0..chars.size) {
            if (end == chars.size || chars[end] == ' ') {
                var left = begin
                var right = end - 1
                while (left < right) {
                    val temp = chars[left]
                    chars[left++] = chars[right]
                    chars[right--] = temp
                }
                begin = end + 1
            }
        }
        return String(chars)
    }
}
