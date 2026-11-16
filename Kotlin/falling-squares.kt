package fallingsquares

// Time:  O(nlogn)
// Space: O(n)

import java.util.TreeMap

class Solution {
    fun fallingSquares(positions: Array<IntArray>): IntArray {
        val result = ArrayList<Int>()
        val heights = TreeMap<Int, Int>()
        heights[-1] = 0
        var maxH = 0
        for (p in positions) {
            val left = p[0]
            val right = p[0] + p[1]
            var h0 = heights.floorEntry(left).value
            val h1 = heights.lowerEntry(right).value
            val keys = heights.subMap(left, false, right, false).keys.toList()
            for (key in keys) {
                h0 = maxOf(h0, heights[key]!!)
            }
            for (key in keys) {
                heights.remove(key)
            }
            heights[left] = h0 + p[1]
            heights[right] = h1
            maxH = maxOf(maxH, h0 + p[1])
            result.add(maxH)
        }
        return result.toIntArray()
    }
}
