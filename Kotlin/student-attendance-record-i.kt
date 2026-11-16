package studentattendancerecordi
// Time:  O(n)
// Space: O(1)

class Solution {
    fun checkRecord(s: String): Boolean {
        var absentCount = 0
        for (i in s.indices) {
            if (s[i] == 'A' && ++absentCount == 2) {
                return false
            }
            if (i + 2 < s.length && s[i] == 'L' && s[i + 1] == 'L' && s[i + 2] == 'L') {
                return false
            }
        }
        return true
    }
}
