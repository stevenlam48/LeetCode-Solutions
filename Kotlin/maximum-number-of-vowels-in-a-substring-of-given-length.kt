package maximumnumberofvowelsinasubstringofgivenlength

// Time:  O(n)
// Space: O(1)

class Solution {
    fun maxVowels(s: String, k: Int): Int {
        val vowels = setOf('a', 'e', 'i', 'o', 'u')
        var result = 0
        var curr = 0
        for (i in s.indices) {
            if (s[i] in vowels) {
                ++curr
            }
            if (i >= k && s[i - k] in vowels) {
                --curr
            }
            result = maxOf(result, curr)
        }
        return result
    }
}
