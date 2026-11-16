package findthelargestareaofsquareinsidetworectangles

// Time:  O(n^2)
// Space: O(1)

class Solution {
    fun largestSquareArea(bottomLeft: Array<IntArray>, topRight: Array<IntArray>): Long {
        var result = 0
        for (i in bottomLeft.indices) {
            for (j in i + 1 until bottomLeft.size) {
                val maxX = maxOf(bottomLeft[i][0], bottomLeft[j][0])
                val minX = minOf(topRight[i][0], topRight[j][0])
                val maxY = maxOf(bottomLeft[i][1], bottomLeft[j][1])
                val minY = minOf(topRight[i][1], topRight[j][1])
                result = maxOf(result, minOf(minX - maxX, minY - maxY))
            }
        }
        return result.toLong() * result
    }
}
