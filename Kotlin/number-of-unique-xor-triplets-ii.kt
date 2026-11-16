package numberofuniquexortripletsii

// Time:  O(nlogn)
// Space: O(n)

class Solution {
    fun uniqueXorTriplets(nums: IntArray): Int {
        val max = nums.maxOrNull() ?: 0
        val bitLength = if (max == 0) 0 else 32 - Integer.numberOfLeadingZeros(max)
        val a = LongArray(1 shl bitLength)
        for (x in nums) {
            ++a[x]
        }
        fst(a, false)
        for (i in a.indices) {
            a[i] = a[i] * a[i] * a[i]
        }
        fst(a, true)
        var result = 0
        for (x in a) {
            if (x != 0L) {
                ++result
            }
        }
        return result
    }

    private fun fst(a: LongArray, inv: Boolean) {
        val n = a.size
        var step = 1
        while (step < n) {
            var i = 0
            while (i < n) {
                for (j in i until i + step) {
                    val u = a[j]
                    val v = a[j + step]
                    a[j] = u + v
                    a[j + step] = u - v
                }
                i += step shl 1
            }
            step = step shl 1
        }
        if (inv) {
            for (i in a.indices) {
                a[i] /= n
            }
        }
    }
}
