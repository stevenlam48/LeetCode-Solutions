package longestsubstringwithatleastkrepeatingcharacters

// Time:  O(26 * n) = O(n)
// Space: O(26) = O(1)

// Recursive solution.
class Solution {
    fun longestSubstring(s: String, k: Int): Int {
        return longestSubstringHelper(s, k, 0, s.length)
    }

    private fun longestSubstringHelper(s: String, k: Int, start: Int, end: Int): Int {
        val count = IntArray(26)
        for (i in start until end) {
            ++count[s[i] - 'a']
        }

        var maxLen = 0
        var i = start
        while (i < end) {
            while (i < end && count[s[i] - 'a'] < k) {
                ++i
            }
            if (i == end) {
                break
            }

            var j = i
            while (j < end && count[s[j] - 'a'] >= k) {
                ++j
            }
            if (i == start && j == end) {
                return end - start
            }

            maxLen = maxOf(maxLen, longestSubstringHelper(s, k, i, j))
            i = j
        }
        return maxLen
    }
}
