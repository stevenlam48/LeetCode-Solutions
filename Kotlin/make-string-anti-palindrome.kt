package makestringantipalindrome

// Time:  O(n + 26)
// Space: O(26)

// counting sort, greedy
class Solution {
    fun makeAntiPalindrome(s: String): String {
        val cnt = IntArray(26)
        for (x in s) {
            ++cnt[x - 'a']
        }
        if ((cnt.maxOrNull() ?: 0) > s.length / 2) {
            return "-1"
        }
        val result = CharArray(s.length)
        var j = 0
        for (i in cnt.indices) {
            repeat(cnt[i]) {
                result[j++] = 'a' + i
            }
        }
        var l = 0
        while (l <= (s.length / 2) / 2) {
            if (result[s.length / 2 + l] != result[s.length / 2 - 1]) {
                break
            }
            ++l
        }
        if (l > 0) {
            val c = result[s.length / 2 - 1] - 'a'
            for (i in 0 until cnt[c] - l) {
                val tmp = result[s.length / 2 + i]
                result[s.length / 2 + i] = result[s.length / 2 + i + l]
                result[s.length / 2 + i + l] = tmp
            }
        }
        return String(result)
    }
}
