package findthelongestsubstringcontainingvowelsinevencounts
// Time:  O(n)
// Space: O(1)

class Solution {
    fun findTheLongestSubstring(s: String): Int {
        val vowels = "aeiou"
        var result = 0
        var mask = 0
        val lookup = IntArray(1 shl vowels.length) { -2 }
        lookup[0] = -1
        for (i in s.indices) {
            val pos = vowels.indexOf(s[i])
            mask = mask xor if (pos != -1) 1 shl pos else 0
            if (lookup[mask] == -2) {
                lookup[mask] = i
            }
            result = maxOf(result, i - lookup[mask])
        }
        return result
    }
}
