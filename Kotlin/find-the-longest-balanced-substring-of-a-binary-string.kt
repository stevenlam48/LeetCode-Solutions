package findthelongestbalancedsubstringofabinarystring
// Time:  O(n)
// Space: O(1)

class Solution {
    fun findTheLongestBalancedSubstring(s: String): Int {
        var result = 0
        for (i in s.indices) {
            var left = i + 1
            var right = i
            while (left - 1 >= 0 && right + 1 < s.length && s[left - 1] == '0' && s[right + 1] == '1') {
                --left
                ++right
            }
            result = maxOf(result, right - left + 1)
        }
        return result
    }
}
