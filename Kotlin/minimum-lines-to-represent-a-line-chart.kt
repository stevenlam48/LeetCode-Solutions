package minimumlinestorepresentalinechart

import kotlin.math.abs

// Time:  O(nlogn)
// Space: O(1)

class Solution {
    fun minimumLines(stockPrices: Array<IntArray>): Int {
        var result = 0
        stockPrices.sortWith(compareBy({ it[0] }, { it[1] }))
        var prev: Pair<Int, Int>? = null
        for (i in 1 until stockPrices.size) {
            val dy = stockPrices[i][1] - stockPrices[i - 1][1]
            val dx = stockPrices[i][0] - stockPrices[i - 1][0]
            val g = gcd(dy, dx)
            val cur = Pair(dy / g, dx / g)
            if (prev == null || prev != cur) {
                prev = cur
                ++result
            }
        }
        return result
    }

    private fun gcd(a: Int, b: Int): Int {
        var x = abs(a)
        var y = abs(b)
        while (y != 0) {
            val t = x % y
            x = y
            y = t
        }
        return x
    }
}
