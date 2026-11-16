package longestsubstringwithoutrepeatingcharacters

// Time:  O(n)
// Space: O(1)

class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        var result = 0
        val lookup = HashMap<Char, Int>()
        var left = 0
        for (right in s.indices) {
            lookup[s[right]]?.let {
                left = maxOf(left, it + 1)
            }
            lookup[s[right]] = right
            result = maxOf(result, right - left + 1)
        }
        return result
    }
}
