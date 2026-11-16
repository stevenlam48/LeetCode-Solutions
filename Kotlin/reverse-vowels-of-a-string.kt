package reversevowelsofastring
// Time:  O(n)
// Space: O(1)

class Solution {
    fun reverseVowels(s: String): String {
        val chars = s.toCharArray()
        var left = 0
        var right = chars.size - 1
        while (left < right) {
            if (!isVowel(chars[left].lowercaseChar())) {
                ++left
            } else if (!isVowel(chars[right].lowercaseChar())) {
                --right
            } else {
                val temp = chars[left]
                chars[left++] = chars[right]
                chars[right--] = temp
            }
        }
        return String(chars)
    }

    private fun isVowel(char: Char): Boolean {
        return char in "aeiou"
    }
}
