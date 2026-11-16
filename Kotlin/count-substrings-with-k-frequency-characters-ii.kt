package countsubstringswithkfrequencycharactersii
// Time:  O(n + 26)
// Space: O(26)

class Solution {
    fun numberOfSubstrings(s: String, k: Int): Long {
        var result = 0L
        val cnt = IntArray(26)
        var left = 0
        for (right in s.indices) {
            ++cnt[s[right] - 'a']
            while (cnt[s[right] - 'a'] == k) {
                result += (s.length - 1) - right + 1
                --cnt[s[left] - 'a']
                ++left
            }
        }
        return result
    }
}
