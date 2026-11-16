package findallanagramsinastring

// Time:  O(n)
// Space: O(1)

class Solution {
    fun findAnagrams(s: String, p: String): List<Int> {
        val result = mutableListOf<Int>()
        if (p.isEmpty() || s.isEmpty()) {
            return result
        }

        val cnts = IntArray(26)
        for (c in p) {
            ++cnts[c - 'a']
        }

        var left = 0
        for (right in s.indices) {
            --cnts[s[right] - 'a']
            while (left <= right && cnts[s[right] - 'a'] < 0) {
                ++cnts[s[left++] - 'a']
            }
            if (right - left + 1 == p.length) {
                result.add(left)
            }
        }
        return result
    }
}
