package uglynumberiii

// Time:  O(logn)
// Space: O(1)

class Solution {
    fun nthUglyNumber(n: Int, a: Int, b: Int, c: Int): Int {
        val aL = a.toLong()
        val bL = b.toLong()
        val cL = c.toLong()
        val lcmAB = lcm(aL, bL)
        val lcmBC = lcm(bL, cL)
        val lcmCA = lcm(cL, aL)
        val lcmABC = lcm(lcmAB, lcmBC)
        var left = 1L
        var right = 2_000_000_000L
        while (left <= right) {
            val mid = left + (right - left) / 2
            if (count(mid, aL, bL, cL, lcmAB, lcmBC, lcmCA, lcmABC) >= n) {
                right = mid - 1
            } else {
                left = mid + 1
            }
        }
        return left.toInt()
    }

    private fun count(
        x: Long,
        a: Long,
        b: Long,
        c: Long,
        lcmAB: Long,
        lcmBC: Long,
        lcmCA: Long,
        lcmABC: Long
    ): Long {
        return x / a + x / b + x / c - (x / lcmAB + x / lcmBC + x / lcmCA) + x / lcmABC
    }

    private fun gcd(a: Long, b: Long): Long {
        var a = a
        var b = b
        while (b != 0L) {
            val tmp = b
            b = a % b
            a = tmp
        }
        return a
    }

    private fun lcm(a: Long, b: Long): Long {
        return a / gcd(a, b) * b
    }
}
