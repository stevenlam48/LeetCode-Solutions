package widestverticalareabetweentwopointscontainingnopoints

import java.util.TreeSet

// Time:  O(nlogn)
// Space: O(n)

class Solution {
    fun maxWidthOfVerticalArea(points: Array<IntArray>): Int {
        val sortedX = TreeSet<Int>()
        for (point in points) {
            sortedX.add(point[0])
        }
        var result = 0
        var prev = -1
        for (x in sortedX) {
            if (prev != -1) {
                result = maxOf(result, x - prev)
            }
            prev = x
        }
        return result
    }
}
