package trimtrailingvowels
// Time:  O(n)
// Space: O(1)

class Solution {
    fun trimTrailingVowels(s: String): String {
        val vowels = "aeiou"
        var end = s.length
        while (end > 0 && vowels.indexOf(s[end - 1]) >= 0) {
            --end
        }
        return s.substring(0, end)
    }
}
