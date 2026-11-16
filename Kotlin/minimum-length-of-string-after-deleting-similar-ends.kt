package minimumlengthofstringafterdeletingsimilarends

// Time:  O(n)
// Space: O(1)

class Solution {
    fun minimumLength(s: String): Int {
        var left = 0
        var right = s.length - 1
        while (left < right) {
            if (s[left] != s[right]) {
                break
            }
            val c = s[left]
            while (left <= right) {
                if (s[left] != c) {
                    break
                }
                ++left
            }
            while (left <= right) {
                if (s[right] != c) {
                    break
                }
                --right
            }
        }
        return right - left + 1
    }
}
