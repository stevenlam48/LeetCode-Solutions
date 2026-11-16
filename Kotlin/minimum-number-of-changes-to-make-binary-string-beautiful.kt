package minimumnumberofchangestomakebinarystringbeautiful
// Time:  O(n)
// Space: O(1)

class Solution {
    fun minChanges(s: String): Int {
        var result = 0
        for (i in s.indices step 2) {
            result += if (s[i] != s[i + 1]) 1 else 0
        }
        return result
    }
}
