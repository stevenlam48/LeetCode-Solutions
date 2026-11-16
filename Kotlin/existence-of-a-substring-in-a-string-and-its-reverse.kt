package existenceofasubstringinastringanditsreverse

// Time:  O(n)
// Space: O(min(n, 26^2))

class Solution {
    fun isSubstringPresent(s: String): Boolean {
        val lookup = Array(26) { BooleanArray(26) }
        for (i in 0 until s.length - 1) {
            lookup[s[i] - 'a'][s[i + 1] - 'a'] = true
        }
        for (i in 0 until s.length - 1) {
            if (lookup[s[i + 1] - 'a'][s[i] - 'a']) {
                return true
            }
        }
        return false
    }
}
