package makeksubarraysumsequal

// Time:  O(n)
// Space: O(n)

// math, greedy, quick select
class Solution {
    fun makeSubKSumEqual(arr: IntArray, k: Int): Long {
        val l = gcd(k, arr.size)
        var result = 0L
        for (i in 0 until l) {
            val vals = ArrayList<Int>()
            var j = i
            while (j < arr.size) {
                vals.add(arr[j])
                j += l
            }
            vals.sort()
            val median = vals[vals.size / 2]
            for (x in vals) {
                result += kotlin.math.abs(x - median).toLong()
            }
        }
        return result
    }

    private fun gcd(a: Int, b: Int): Int {
        var x = a
        var y = b
        while (y != 0) {
            val t = y
            y = x % y
            x = t
        }
        return x
    }
}
