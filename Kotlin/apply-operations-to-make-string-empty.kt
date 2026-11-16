package applyoperationstomakestringempty

// Time:  O(n)
// Space: O(1)

class Solution {
    fun lastNonEmptyString(s: String): String {
        val cnt = IntArray(26)
        for (x in s) {
            ++cnt[x - 'a']
        }
        val result = StringBuilder()
        val mx = cnt.max()
        for (i in s.length - 1 downTo 0) {
            if (cnt[s[i] - 'a'] != mx) {
                continue
            }
            --cnt[s[i] - 'a']
            result.append(s[i])
        }
        return result.reverse().toString()
    }
}
