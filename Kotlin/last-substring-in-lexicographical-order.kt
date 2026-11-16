package lastsubstringinlexicographicalorder

// Time:  O(n)
// Space: O(1)

class Solution {
    fun lastSubstring(s: String): String {
        var left = 0
        var right = 1
        var l = 0
        while (right + l < s.length) {
            if (s[left + l] == s[right + l]) {
                ++l
                continue
            }
            if (s[left + l] > s[right + l]) {
                right += l + 1
            } else {
                left = maxOf(right, left + l + 1)
                right = left + 1
            }
            l = 0
        }
        return s.substring(left)
    }
}
