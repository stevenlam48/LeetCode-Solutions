package statisticsfromalargesample

// Time:  O(n)
// Space: O(1)

class Solution {
    fun sampleStats(count: IntArray): DoubleArray {
        val c = count.copyOf()

        var mi = 0
        while (c[mi] == 0) {
            ++mi
        }

        var ma = c.size - 1
        while (c[ma] == 0) {
            --ma
        }

        var n = 0
        for (x in c) {
            n += x
        }
        var total = 0.0
        for (i in c.indices) {
            total += i.toDouble() * c[i]
        }
        val mean = total / n

        var mode = 0
        for (i in c.indices) {
            if (c[i] > c[mode]) {
                mode = i
            }
        }

        for (i in 1 until c.size) {
            c[i] += c[i - 1]
        }
        val median1 = lowerBound(c, (n + 1) / 2)
        val median2 = lowerBound(c, (n + 2) / 2)
        val median = (median1 + median2) / 2.0

        return doubleArrayOf(mi.toDouble(), ma.toDouble(), mean, median, mode.toDouble())
    }

    private fun lowerBound(a: IntArray, target: Int): Int {
        var lo = 0
        var hi = a.size
        while (lo < hi) {
            val mid = (lo + hi) ushr 1
            if (a[mid] < target) {
                lo = mid + 1
            } else {
                hi = mid
            }
        }
        return lo
    }
}
