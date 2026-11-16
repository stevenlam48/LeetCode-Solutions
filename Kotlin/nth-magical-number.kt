package nthmagicalnumber

// Time:  O(logn)
// Space: O(1)

class Solution {
    fun nthMagicalNumber(N: Int, A: Int, B: Int): Int {
        val M = 1000000007
        val a = A.toLong()
        val b = B.toLong()
        val lcm = a * b / gcd(a, b)

        var left = minOf(a, b)
        var right = maxOf(a, b) * N
        while (left <= right) {
            val mid = left + (right - left) / 2
            if (check(A, B, N, lcm, mid)) {
                right = mid - 1
            } else {
                left = mid + 1
            }
        }
        return (left % M).toInt()
    }

    private fun check(a: Int, b: Int, N: Int, lcm: Long, target: Long): Boolean {
        return target / a + target / b - target / lcm >= N
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
}
