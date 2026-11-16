package minimumswapstomakestringsequal

// Time:  O(n)
// Space: O(1)

class Solution {
    fun minimumSwap(s1: String, s2: String): Int {
        var x1 = 0
        var y1 = 0
        for (i in s1.indices) {
            if (s1[i] == s2[i]) {
                continue
            }
            if (s1[i] == 'x') {
                ++x1
            } else {
                ++y1
            }
        }
        if (x1 % 2 != y1 % 2) {
            return -1
        }
        return x1 / 2 + y1 / 2 + x1 % 2 + y1 % 2
    }
}
