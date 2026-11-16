package reversewordsinastring
// Time:  O(n)
// Space: O(1)

class Solution {
    fun reverseWords(s: String): String {
        val chars = s.toCharArray()
        reverse(chars, 0, chars.size)
        var end = 0
        var length = 0
        while (true) {
            var begin = end
            while (begin < chars.size && chars[begin] == ' ') ++begin
            if (begin == chars.size) break
            end = begin
            while (end < chars.size && chars[end] != ' ') ++end
            reverse(chars, begin, end)
            for (i in begin until end) chars[length++] = chars[i]
            if (length < chars.size) chars[length] = ' '
            ++length
        }
        return String(chars, 0, if (length > 0) length - 1 else 0)
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
