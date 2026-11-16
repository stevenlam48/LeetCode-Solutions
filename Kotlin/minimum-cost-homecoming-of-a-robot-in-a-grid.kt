package minimumcosthomecomingofarobotinagrid

// Time:  O(m + n)
// Space: O(1)

class Solution {
    fun minCost(startPos: IntArray, homePos: IntArray, rowCosts: IntArray, colCosts: IntArray): Int {
        var result = -rowCosts[startPos[0]] - colCosts[startPos[1]]
        for (r in minOf(startPos[0], homePos[0])..maxOf(startPos[0], homePos[0])) {
            result += rowCosts[r]
        }
        for (c in minOf(startPos[1], homePos[1])..maxOf(startPos[1], homePos[1])) {
            result += colCosts[c]
        }
        return result
    }
}
