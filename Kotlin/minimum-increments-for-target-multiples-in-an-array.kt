package minimumincrementsfortargetmultiplesinanarray
// Time:  O(logr * m * 2^m + n * 3^m)
// Space: O(2^m)

class Solution {
    fun minimumIncrements(nums: IntArray, target: IntArray): Int {
        val inf = Long.MAX_VALUE
        val m = target.size
        val lcms = LongArray(1 shl m)
        for (mask in 0 until (1 shl m)) {
            var l = 1L
            for (i in 0 until m) {
                if ((mask and (1 shl i)) != 0) {
                    l = lcm(l, target[i].toLong())
                }
            }
            lcms[mask] = l
        }
        val dp = LongArray(1 shl m) { inf }
        dp[0] = 0
        for (x in nums) {
            for (mask in (1 shl m) - 1 downTo 0) {
                if (dp[mask] == inf) {
                    continue
                }
                val newMask = ((1 shl m) - 1) - mask
                var submask = newMask
                while (submask != 0) {
                    val remainder = x.toLong() % lcms[submask]
                    val increment = if (remainder != 0L) lcms[submask] - remainder else 0
                    dp[mask or submask] = minOf(dp[mask or submask], dp[mask] + increment)
                    submask = (submask - 1) and newMask
                }
            }
        }
        return dp[(1 shl m) - 1].toInt()
    }

    private fun lcm(a: Long, b: Long): Long {
        return a / gcd(a, b) * b
    }

    private fun gcd(a: Long, b: Long): Long {
        var x = a
        var y = b
        while (y != 0L) {
            val remainder = x % y
            x = y
            y = remainder
        }
        return x
    }
}
