package separatesquaresi

// Time:  O(nlogn)
// Space: O(n)

class Solution {
    fun separateSquares(squares: Array<IntArray>): Double {
        val events = ArrayList<IntArray>()
        for (s in squares) {
            events.add(intArrayOf(s[1], 1, s[2]))
            events.add(intArrayOf(s[1] + s[2], -1, s[2]))
        }
        events.sortBy { it[0] }
        var total = 0.0
        var curr = 0.0
        var prev = events[0][0]
        for (e in events) {
            val y = e[0]
            if (y != prev) {
                total += (y - prev) * curr
                prev = y
            }
            curr += e[2].toDouble() * e[1]
        }
        val expect = total / 2.0
        total = 0.0
        curr = 0.0
        prev = events[0][0]
        for (e in events) {
            val y = e[0]
            if (y != prev) {
                if (total + (y - prev) * curr >= expect) {
                    break
                }
                total += (y - prev) * curr
                prev = y
            }
            curr += e[2].toDouble() * e[1]
        }
        return prev + (expect - total) / curr
    }
}
