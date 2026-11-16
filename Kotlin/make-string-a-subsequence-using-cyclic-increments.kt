package makestringasubsequenceusingcyclicincrements

// Time:  O(n)
// Space: O(1)

// greedy, two pointers
class Solution {
    fun canMakeSubsequence(str1: String, str2: String): Boolean {
        if (str2.isEmpty()) {
            return false
        }
        var i = 0
        for (c in str1) {
            if (((str2[i] - c) % 26 + 26) % 26 > 1) {
                continue
            }
            if (++i == str2.length) {
                return true
            }
        }
        return false
    }
}
