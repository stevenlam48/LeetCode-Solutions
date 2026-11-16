package longestsubstringwithatmosttwodistinctcharacters

// Time:  O(n)
// Space: O(1)

class Solution {
    fun lengthOfLongestSubstringTwoDistinct(s: String): Int {
        val k = 2
        var longest = 0
        var start = 0
        var distinctCount = 0
        val visited = IntArray(256)
        for (i in s.indices) {
            if (visited[s[i].code] == 0) {
                ++distinctCount
            }
            ++visited[s[i].code]
            while (distinctCount > k) {
                --visited[s[start].code]
                if (visited[s[start].code] == 0) {
                    --distinctCount
                }
                ++start
            }
            longest = maxOf(longest, i - start + 1)
        }
        return longest
    }
}
