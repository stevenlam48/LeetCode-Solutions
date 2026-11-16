package largestsubstringbetweentwoequalcharacters

// Time:  O(n)
// Space: O(1)

class Solution {
    fun maxLengthBetweenEqualCharacters(s: String): Int {
        var result = -1
        val lookup = IntArray(26) { -1 }
        for (i in s.indices) {
            if (lookup[s[i] - 'a'] >= 0) {
                result = maxOf(result, i - lookup[s[i] - 'a'] - 1)
            } else {
                lookup[s[i] - 'a'] = i
            }
        }
        return result
    }
}
