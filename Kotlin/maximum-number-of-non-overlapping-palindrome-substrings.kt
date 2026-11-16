package maximumnumberofnonoverlappingpalindromesubstrings
// Time:  O(n * k)
// Space: O(1)

class Solution {
    fun maxPalindromes(s: String, k: Int): Int {
        var result = 0
        var prev = 0
        for (mid in 0 until 2 * s.length - 1) {
            var left = mid / 2
            var right = mid / 2 + mid % 2
            while (left >= prev && right < s.length && s[left] == s[right]) {
                if (right - left + 1 >= k) {
                    prev = right + 1
                    ++result
                    break
                }
                --left
                ++right
            }
        }
        return result
    }
}
