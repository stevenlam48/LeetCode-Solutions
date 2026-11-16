package uglynumberii

// Time:  O(n)
// Space: O(n)

class Solution {
    fun nthUglyNumber(n: Int): Int {
        val uglies = IntArray(n)
        uglies[0] = 1

        var f2 = 2
        var f3 = 3
        var f5 = 5
        var idx2 = 0
        var idx3 = 0
        var idx5 = 0

        for (i in 1 until n) {
            val minVal = minOf(minOf(f2, f3), f5)
            uglies[i] = minVal

            if (minVal == f2) {
                f2 = 2 * uglies[++idx2]
            }
            if (minVal == f3) {
                f3 = 3 * uglies[++idx3]
            }
            if (minVal == f5) {
                f5 = 5 * uglies[++idx5]
            }
        }

        return uglies[n - 1]
    }
}
