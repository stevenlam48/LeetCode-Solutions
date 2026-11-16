package numberofsegmentsinastring

// Time:  O(n)
// Space: O(1)

class Solution {
    fun countSegments(s: String): Int {
        var result = if (s.isNotEmpty() && s.last() != ' ') 1 else 0
        for (i in 1 until s.length) {
            if (s[i] == ' ' && s[i - 1] != ' ') {
                ++result
            }
        }
        return result
    }
}
