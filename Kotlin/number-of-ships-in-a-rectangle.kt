package numberofshipsinarectangle

// Time:  O(s * log(m * n)), s is the max number of ships, which is 10 in this problem
// Space: O(log(m * n))

interface Sea {
    fun hasShips(topRight: IntArray, bottomLeft: IntArray): Boolean
}

class Solution {
    fun countShips(sea: Sea, topRight: IntArray, bottomLeft: IntArray): Int {
        var result = 0
        if (topRight[0] >= bottomLeft[0] &&
            topRight[1] >= bottomLeft[1] &&
            sea.hasShips(topRight, bottomLeft)
        ) {
            if (topRight.contentEquals(bottomLeft)) {
                return 1
            }
            val midX = (topRight[0] + bottomLeft[0]) / 2
            val midY = (topRight[1] + bottomLeft[1]) / 2
            result += countShips(sea, topRight, intArrayOf(midX + 1, midY + 1))
            result += countShips(sea, intArrayOf(midX, topRight[1]), intArrayOf(bottomLeft[0], midY + 1))
            result += countShips(sea, intArrayOf(topRight[0], midY), intArrayOf(midX + 1, bottomLeft[1]))
            result += countShips(sea, intArrayOf(midX, midY), bottomLeft)
        }
        return result
    }
}
