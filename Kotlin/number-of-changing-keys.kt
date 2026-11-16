package numberofchangingkeys
// Time:  O(n)
// Space: O(1)

class Solution {
    fun countKeyChanges(s: String): Int {
        var result = 0
        for (i in 0 until s.length - 1) {
            result += if (s[i].lowercaseChar() != s[i + 1].lowercaseChar()) 1 else 0
        }
        return result
    }
}
