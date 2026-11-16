package countasterisks

// Time:  O(n)
// Space: O(1)

class Solution {
    fun countAsterisks(s: String): Int {
        var result = 0
        var cnt = 0
        for (c in s) {
            if (c == '|') {
                cnt = (cnt + 1) % 2
                continue
            }
            if (c == '*' && cnt == 0) {
                ++result
            }
        }
        return result
    }
}
