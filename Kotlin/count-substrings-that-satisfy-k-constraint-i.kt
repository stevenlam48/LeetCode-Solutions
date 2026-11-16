package countsubstringsthatsatisfykconstrainti
// Time:  O(n)
// Space: O(1)

class Solution {
    fun countKConstraintSubstrings(s: String, k: Int): Int {
        var result = 0
        var left = 0
        var cnt = 0
        for (right in s.indices) {
            cnt += if (s[right] == '1') 1 else 0
            while (!(cnt <= k || right - left + 1 - cnt <= k)) {
                cnt -= if (s[left] == '1') 1 else 0
                ++left
            }
            result += right - left + 1
        }
        return result
    }
}
