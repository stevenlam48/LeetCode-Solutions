package maximumnumberofpeoplethatcanbecaughtintag

// Time:  O(n)
// Space: O(1)

class Solution {
    fun catchMaximumAmountofPeople(team: IntArray, dist: Int): Int {
        var result = 0
        var i = 0
        var j = 0
        while (i < team.size && j < team.size) {
            if (i + dist < j || team[i] != 1) {
                ++i
            } else if (j + dist < i || team[j] != 0) {
                ++j
            } else {
                ++result
                ++i
                ++j
            }
        }
        return result
    }
}
