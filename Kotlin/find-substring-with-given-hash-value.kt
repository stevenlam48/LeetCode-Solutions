package findsubstringwithgivenhashvalue

// Time:  O(n)
// Space: O(1)

// rolling hash
class Solution {
    fun subStrHash(s: String, power: Int, modulo: Int, k: Int, hashValue: Int): String {
        var idx = 0
        var pw = 1L
        var h = 0L
        var i = s.length - 1L
        while (i >= 0) {
            if ((s.length - 1) - i + 1 <= k - 1) {
                pw = (pw * power) % modulo
            }
            if (i + k < s.length) {
                h = (h - (s[(i + k).toInt()] - 'a' + 1) * pw % modulo + modulo) % modulo
            }
            h = (h * power % modulo + (s[i.toInt()] - 'a' + 1)) % modulo
            if (h == hashValue.toLong()) {
                idx = i.toInt()
            }
            --i
        }
        return s.substring(idx, idx + k)
    }
}
