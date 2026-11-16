package findthefirstplayertowinkgamesinarow

// Time:  O(n)
// Space: O(1)

class Solution {
    fun findWinningPlayer(skills: IntArray, k: Int): Int {
        var result = 0
        var cnt = 0
        for (i in 1 until skills.size) {
            if (skills[result] < skills[i]) {
                result = i
                cnt = 0
            }
            if (++cnt == k) {
                return result
            }
        }
        return result
    }
}
