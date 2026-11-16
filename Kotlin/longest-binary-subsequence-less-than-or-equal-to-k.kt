package longestbinarysubsequencelessthanorequaltok

// Time:  O(n)
// Space: O(1)

// greedy
class Solution {
    fun longestSubsequence(s: String, k0: Int): Int {
        var k = k0
        var result = 0
        var base = 1
        for (i in s.length - 1 downTo 0) {
            if (s[i] == '0') {
                ++result
            } else if (base <= k) {
                k -= base
                ++result
            }
            if (base <= k) {
                base = base shl 1
            }
        }
        return result
    }
}
