package constructkpalindromestrings

// Time:  O(n)
// Space: O(1)

class Solution {
    fun canConstruct(s: String, k: Int): Boolean {
        val odd = BooleanArray(26)
        for (c in s) {
            odd[c - 'a'] = !odd[c - 'a']
        }
        return odd.count { it } <= k && k <= s.length
    }
}
