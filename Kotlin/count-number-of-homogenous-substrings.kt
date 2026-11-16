package countnumberofhomogenoussubstrings

// Time:  O(n)
// Space; O(1)

class Solution {
    fun countHomogenous(s: String): Int {
        val mod = 1_000_000_007
        var cnt = 0
        var result = 0
        for (i in s.indices) {
            if (i > 0 && s[i - 1] == s[i]) {
                ++cnt
            } else {
                cnt = 1
            }
            result = (result + cnt) % mod
        }
        return result
    }
}
