package numberofrectanglesthatcanformthelargestsquare

// Time:  O(n)
// Space: O(1)

class Solution {
    fun countGoodRectangles(rectangles: Array<IntArray>): Int {
        var result = 0
        var mx = 0
        for (rec in rectangles) {
            val side = minOf(rec[0], rec[1])
            if (side > mx) {
                mx = side
                result = 1
            } else if (side == mx) {
                ++result
            }
        }
        return result
    }
}
