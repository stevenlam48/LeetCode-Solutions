package countsubstringswithkfrequencycharactersi
// Time:  O(n + 26)
// Space: O(26)

class Solution {
    fun numberOfSubstrings(s: String, k: Int): Int {
        fun count(): Int {
            var result = 0
            val cnt = IntArray(26)
            var left = 0
            for (right in s.indices) {
                ++cnt[s[right] - 'a']
                while (cnt[s[right] - 'a'] == k) {
                    --cnt[s[left] - 'a']
                    ++left
                }
                result += right - left + 1
            }
            return result
        }

        return (s.length + 1) * s.length / 2 - count()
    }
}
