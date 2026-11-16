package spiralmatrixiii

// Time:  O(max(m, n)^2)
// Space: O(1)

class Solution {
    fun spiralMatrixIII(R: Int, C: Int, r0: Int, c0: Int): Array<IntArray> {
        var r = r0
        var c = c0
        val result = mutableListOf(intArrayOf(r, c))
        var x = 0
        var y = 1
        var i = 0
        var n = 0
        while (result.size < R * C) {
            r += x
            c += y
            ++i
            if (0 <= r && r < R && 0 <= c && c < C) {
                result.add(intArrayOf(r, c))
            }
            if (i == n / 2 + 1) {
                val tmp = x
                x = y
                y = tmp
                y *= -1
                ++n
                i = 0
            }
        }
        return result.toTypedArray()
    }
}
