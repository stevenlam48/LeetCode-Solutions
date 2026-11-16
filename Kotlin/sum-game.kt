package sumgame

// Time:  O(n)
// Space: O(1)
class Solution {
    fun sumGame(num: String): Boolean {
        var cnt = 0
        var total = 0
        for (i in num.indices) {
            if (num[i] == '?') {
                cnt += if (i < num.length / 2) -1 else 1
            } else {
                total += if (i < num.length / 2) num[i] - '0' else -(num[i] - '0')
            }
        }
        return if (cnt % 2 != 0) true else total != cnt / 2 * 9
    }
}
