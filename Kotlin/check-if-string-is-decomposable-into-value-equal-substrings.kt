package checkifstringisdecomposableintovalueequalsubstrings

// Time:  O(n)
// Space: O(1)
class Solution {
    fun isDecomposable(s: String): Boolean {
        if (s.length % 3 != 2) {
            return false
        }
        var left = 0
        while (left < s.length) {
            val end = minOf(left + 3, s.length)
            var unequal = false
            for (i in left until end - 1) {
                if (s[i] != s[i + 1]) {
                    unequal = true
                    break
                }
            }
            if (unequal) {
                break
            }
            left += 3
        }
        var right = s.length - 1
        while (right >= left + 1) {
            val start = maxOf(right - 2, left)
            var unequal = false
            for (i in start until right) {
                if (s[i] != s[i + 1]) {
                    unequal = true
                    break
                }
            }
            if (unequal) {
                break
            }
            right -= 3
        }
        return (right + 3) - left == 1
    }
}
