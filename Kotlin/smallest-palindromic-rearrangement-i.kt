package smallestpalindromicrearrangementi
// Time:  O(n + 26)
// Space: O(26)

class Solution {
    fun smallestPalindrome(s: String): String {
        val cnt = IntArray(26)
        for (i in 0 until s.length / 2) {
            ++cnt[s[i] - 'a']
        }
        val result = CharArray(s.length)
        var l = 0
        for (i in cnt.indices) {
            repeat(cnt[i]) {
                result[l++] = 'a' + i
            }
        }
        if (s.length % 2 != 0) {
            result[l++] = s[s.length / 2]
        }
        for (i in l - 1 - s.length % 2 downTo 0) {
            result[l++] = result[i]
        }
        return String(result)
    }
}
