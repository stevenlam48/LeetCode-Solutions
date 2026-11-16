package reversewordswithsamevowelcount
// Time:  O(n)
// Space: O(1)

class Solution {
    fun reverseWords(s: String): String {
        val chars = s.toCharArray()
        var wordLength = 0
        var firstVowelCount = -1
        for (i in chars.indices) {
            if (chars[i] == ' ') {
                wordLength = 0
                continue
            }
            ++wordLength
            if (i + 1 != chars.size && chars[i + 1] != ' ') continue
            val begin = i - wordLength + 1
            var vowelCount = 0
            for (j in begin..i) {
                if (chars[j] in "aeiou") ++vowelCount
            }
            if (firstVowelCount == -1) {
                firstVowelCount = vowelCount
            } else if (firstVowelCount == vowelCount) {
                var left = begin
                var right = i
                while (left < right) {
                    val temp = chars[left]
                    chars[left++] = chars[right]
                    chars[right--] = temp
                }
            }
        }
        return String(chars)
    }
}
