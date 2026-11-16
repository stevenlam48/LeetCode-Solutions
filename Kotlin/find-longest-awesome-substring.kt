package findlongestawesomesubstring
// Time:  O(10 * n)
// Space: O(1024)

class Solution {
    fun longestAwesome(s: String): Int {
        var result = 0
        var mask = 0
        val lookup = IntArray(1 shl 10) { s.length }
        lookup[0] = -1
        for (i in s.indices) {
            mask = mask xor (1 shl (s[i] - '0'))
            if (lookup[mask] == s.length) {
                lookup[mask] = i
            }
            result = maxOf(result, i - lookup[mask])
            for (d in 0 until 10) {
                result = maxOf(result, i - lookup[mask xor (1 shl d)])
            }
            lookup[mask] = minOf(lookup[mask], i)
        }
        return result
    }
}
