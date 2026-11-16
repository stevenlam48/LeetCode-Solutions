package findspecialsubstringoflengthk

// Time:  O(n)
// Space: O(1)

// string
class Solution {
    fun hasSpecialSubstring(s: String, k: Int): Boolean {
        var l = 0
        for (i in s.indices) {
            ++l
            if (i + 1 == s.length || s[i] != s[i + 1]) {
                if (l == k) {
                    return true
                }
                l = 0
            }
        }
        return false
    }
}
