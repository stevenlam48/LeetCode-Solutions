package removecoloredpiecesifbothneighborsarethesamecolor
// Time:  O(n)
// Space: O(1)

class Solution {
    fun winnerOfGame(colors: String): Boolean {
        var cnt1 = 0
        var cnt2 = 0
        for (i in 1 until colors.length - 1) {
            if (!(colors[i - 1] == colors[i] && colors[i] == colors[i + 1])) {
                continue
            }
            if (colors[i] == 'A') {
                ++cnt1
            } else {
                ++cnt2
            }
        }
        return cnt1 > cnt2
    }
}
