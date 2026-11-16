package reverseprefixofword
// Time:  O(n)
// Space: O(1)

class Solution {
    fun reversePrefix(word: String, ch: Char): String {
        val chars = word.toCharArray()
        var left = 0
        var right = word.indexOf(ch)
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
