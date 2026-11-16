package uniquesubstringsinwraparoundstring

// Time:  O(n)
// Space: O(1)

class Solution {
    fun findSubstringInWraproundString(p: String): Int {
        val letters = IntArray(26)
        var result = 0
        var len = 0
        for (i in p.indices) {
            val curr = p[i] - 'a'
            if (i > 0 && p[i - 1].code != (curr + 26 - 1) % 26 + 'a'.code) {
                len = 0
            }
            ++len
            if (len > letters[curr]) {
                result += len - letters[curr]
                letters[curr] = len
            }
        }
        return result
    }
}
