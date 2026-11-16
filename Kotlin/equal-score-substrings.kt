package equalscoresubstrings

// Time:  O(n)
// Space: O(1)
class Solution {
    fun scoreBalance(s: String): Boolean {
        var total = 0
        for (x in s) {
            total += x - 'a' + 1
        }
        var prefix = 0
        for (x in s) {
            prefix += x - 'a' + 1
            if (prefix == total - prefix) {
                return true
            }
        }
        return false
    }
}
