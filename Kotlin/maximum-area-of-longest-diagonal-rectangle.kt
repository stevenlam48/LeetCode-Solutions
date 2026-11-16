package maximumareaoflongestdiagonalrectangle

// Time:  O(n)
// Space: O(1)

class Solution {
    fun areaOfMaxDiagonal(dimensions: Array<IntArray>): Int {
        var diagonal = 0
        var area = 0
        for (d in dimensions) {
            val currentDiagonal = d[0] * d[0] + d[1] * d[1]
            val currentArea = d[0] * d[1]
            if (currentDiagonal > diagonal || currentDiagonal == diagonal && currentArea > area) {
                diagonal = currentDiagonal
                area = currentArea
            }
        }
        return area
    }
}
