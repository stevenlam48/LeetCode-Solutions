package takekofeachcharacterfromleftandright
// Time:  O(n)
// Space: O(1)

class Solution {
    fun takeCharacters(s: String, k: Int): Int {
        val cnt = IntArray(3)
        for (c in s) {
            ++cnt[c - 'a']
        }
        if (cnt.minOrNull()!! < k) {
            return -1
        }
        var result = 0
        var left = 0
        for (right in s.indices) {
            --cnt[s[right] - 'a']
            while (cnt[s[right] - 'a'] < k) {
                ++cnt[s[left++] - 'a']
            }
            result = maxOf(result, right - left + 1)
        }
        return s.length - result
    }
}
