package fillaspecialgrid

// Time:  O(4^n)
// Space: O(1)

class Solution {
    fun specialGrid(n: Int): Array<IntArray> {
        val total = 1 shl n
        val result = Array(total) { IntArray(total) }
        fun copy(l: Int, r1: Int, c1: Int, r2: Int, c2: Int) {
            for (i in 0 until l) {
                for (j in 0 until l) {
                    result[r2 + i][c2 + j] = result[r1 + i][c1 + j] + l * l
                }
            }
        }

        var l = 1
        for (i in 0 until n) {
            var r = 0
            var c = total - l
            for ((dr, dc) in arrayOf(l to 0, 0 to -l, -l to 0)) {
                val nr = r + dr
                val nc = c + dc
                copy(l, r, c, nr, nc)
                r = nr
                c = nc
            }
            l = l shl 1
        }
        return result
    }
}
