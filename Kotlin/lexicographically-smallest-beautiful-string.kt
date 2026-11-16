package lexicographicallysmallestbeautifulstring

// Time:  O(n)
// Space: O(1)

class Solution {
    fun smallestBeautifulString(s: String, k: Int): String {
        val chars = s.toCharArray()

        fun check(i: Int): Boolean =
            (i - 1 < 0 || chars[i - 1] != chars[i]) && (i - 2 < 0 || chars[i - 2] != chars[i])

        var i = chars.size - 1
        while (i >= 0) {
            ++chars[i]
            while (!check(i)) {
                ++chars[i]
            }
            if (chars[i] - 'a' < k) {
                break
            }
            --i
        }
        if (i < 0) {
            return ""
        }
        var j = i + 1
        while (j < chars.size) {
            chars[j] = 'a'
            while (!check(j)) {
                ++chars[j]
            }
            ++j
        }
        return String(chars)
    }
}
