package minimummovestoconvertstring

// Time:  O(n)
// Space: O(1)

class Solution {
    fun minimumMoves(s: String): Int {
        var result = 0
        var i = 0
        while (i < s.length) {
            if (s[i] == 'X') {
                ++result
                i += 3
            } else {
                i += 1
            }
        }
        return result
    }
}
