package kthsmallestinstructions

// Time:  O((m + n)^2)
// Space: O(1)

class Solution {
    fun kthSmallestPath(destination: IntArray, k: Int): String {
        var r = destination[0]
        var c = destination[1]
        var remaining = k.toLong()
        val result = StringBuilder()
        while (r + c != 0) {
            val count = nCr(r + c - 1, r)
            if (remaining <= count) {
                --c
                result.append('H')
            } else {
                remaining -= count
                --r
                result.append('V')
            }
        }
        return result.toString()
    }

    private fun nCr(n: Int, r: Int): Long {
        if (n < r) {
            return 0
        }
        if (n - r < r) {
            return nCr(n, n - r)
        }
        var c = 1L
        for (k in 1..r) {
            c *= (n - k + 1).toLong()
            c /= k
        }
        return c
    }
}
