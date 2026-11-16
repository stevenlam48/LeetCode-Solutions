package perfectrectangle

// Time:  O(n)
// Space: O(n)

class Solution {
    fun isRectangleCover(rectangles: Array<IntArray>): Boolean {
        val L = 0
        val B = 1
        val R = 2
        val T = 3
        var left = Int.MAX_VALUE
        var bottom = Int.MAX_VALUE
        var right = Int.MIN_VALUE
        var top = Int.MIN_VALUE
        for (rect in rectangles) {
            left = minOf(left, rect[L])
            bottom = minOf(bottom, rect[B])
            right = maxOf(right, rect[R])
            top = maxOf(top, rect[T])
        }

        val LB = 1
        val RB = 2
        val LT = 4
        val RT = 8
        val cornerCount = HashMap<Int, HashMap<Int, Int>>()
        val corners = arrayOf(
            intArrayOf(L, B, LB),
            intArrayOf(R, B, RB),
            intArrayOf(L, T, LT),
            intArrayOf(R, T, RT)
        )
        for (rect in rectangles) {
            for (corner in corners) {
                val x = rect[corner[0]]
                val y = rect[corner[1]]
                val row = cornerCount.getOrPut(x) { HashMap() }
                if (((row[y] ?: 0) and corner[2]) != 0) {
                    return false
                }
                row[y] = (row[y] ?: 0) or corner[2]
            }
        }

        val isValid = BooleanArray(16)
        isValid[LB or RB] = true
        isValid[LB or LT] = true
        isValid[RB or RT] = true
        isValid[LT or RT] = true
        isValid[LB or RB or LT or RT] = true
        for ((x, row) in cornerCount) {
            for ((y, mask) in row) {
                if ((left < x && x < right) || (bottom < y && y < top)) {
                    if (!isValid[mask]) {
                        return false
                    }
                }
            }
        }

        return true
    }
}
