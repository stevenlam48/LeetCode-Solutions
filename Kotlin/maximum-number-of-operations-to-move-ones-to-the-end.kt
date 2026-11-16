package maximumnumberofoperationstomoveonestotheend
// Time:  O(n)
// Space: O(1)

class Solution {
    fun maxOperations(s: String): Int {
        var result = 0
        var curr = 0
        for (i in s.indices) {
            if (s[i] == '1') {
                ++curr
            } else if (i + 1 == s.length || s[i + 1] == '1') {
                result += curr
            }
        }
        return result
    }
}
