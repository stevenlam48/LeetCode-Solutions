package countthenumberofhousesatacertaindistanceii

// Time:  O(n)
// Space: O(1)

// math, prefix sum, difference array
class Solution {
    fun countOfPairs(n: Int, x0: Int, y0: Int): LongArray {
        var x = x0 - 1
        var y = y0 - 1
        if (x > y) {
            val t = x
            x = y
            y = t
        }
        val diff = LongArray(n)
        for (i in 0 until n) {
            diff[0] += 1 + 1
            ++diff[minOf(Math.abs(i - x), Math.abs(i - y) + 1)]
            ++diff[minOf(Math.abs(i - y), Math.abs(i - x) + 1)]
            --diff[minOf(Math.abs(i - 0), Math.abs(i - y) + 1 + Math.abs(x - 0))]
            --diff[minOf(Math.abs(i - (n - 1)), Math.abs(i - x) + 1 + Math.abs(y - (n - 1)))]
            --diff[maxOf(x - i, 0) + maxOf(i - y, 0) + (y - x) / 2]
            --diff[maxOf(x - i, 0) + maxOf(i - y, 0) + (y - x + 1) / 2]
        }
        for (i in 0 until n - 1) {
            diff[i + 1] += diff[i]
        }
        return diff
    }
}
