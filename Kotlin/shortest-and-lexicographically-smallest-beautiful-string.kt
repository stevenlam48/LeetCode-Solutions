package shortestandlexicographicallysmallestbeautifulstring

// Time:  O(n^2)
// Space: O(1)

class Solution {
    fun shortestBeautifulSubstring(s: String, k: Int): String {
        var result = intArrayOf()
        var left = 0
        var current = 0
        for (right in s.indices) {
            if (s[right] == '1') {
                ++current
            }
            while (current == k + 1) {
                if (s[left++] == '1') {
                    --current
                }
            }
            while (left < s.length && s[left] == '0') {
                ++left
            }
            if (current == k &&
                (result.isEmpty() || isBetter(s, left, right, result[0], result[1]))
            ) {
                result = intArrayOf(left, right)
            }
        }
        return if (result.isNotEmpty()) {
            s.substring(result[0], result[1] + 1)
        } else {
            ""
        }
    }

    private fun isBetter(s: String, l1: Int, r1: Int, l2: Int, r2: Int): Boolean {
        val count1 = r1 - l1 + 1
        val count2 = r2 - l2 + 1
        if (count1 > count2) {
            return false
        }
        if (count1 < count2) {
            return true
        }
        for (i in 0 until count1) {
            if (s[l1 + i] != s[l2 + i]) {
                return s[l1 + i] < s[l2 + i]
            }
        }
        return false
    }
}
