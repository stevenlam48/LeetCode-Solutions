package twolettercardgame

// Time:  O(n + 26)
// Space: O(26)

class Solution {
    fun score(cards: List<String>, x: Char): Int {
        val cnt1 = IntArray(26)
        val cnt2 = IntArray(26)
        var cnt3 = 0
        for (s in cards) {
            if (s.indexOf(x) == -1) {
                continue
            }
            if (s[0] == x && s[1] == x) {
                ++cnt3
            } else if (s[0] == x) {
                ++cnt1[s[1] - 'a']
            } else if (s[1] == x) {
                ++cnt2[s[0] - 'a']
            }
        }
        val total1 = cnt1.sum()
        val total2 = cnt2.sum()
        val mx1 = cnt1.max()
        val mx2 = cnt2.max()
        val pair1 = minOf(total1 - mx1, total1 / 2)
        val pair2 = minOf(total2 - mx2, total2 / 2)
        val pair3 = minOf((total1 - 2 * pair1) + (total2 - 2 * pair2), cnt3)
        return (pair1 + pair2) + pair3 + minOf(pair1 + pair2, (cnt3 - pair3) / 2)
    }
}
