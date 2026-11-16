package incrementalmemoryleak

import kotlin.math.sqrt

// Time:  O(1)
// Space: O(1)

// Same problem from https://codingcompetitions.withgoogle.com/codejam/round/000000000019ffb9/00000000003384ea
class Solution {
    fun memLeak(memory1: Int, memory2: Int): IntArray {
        var m1 = memory1
        var m2 = memory2
        var is_swapped = false
        if (m1 < m2) {
            val tmp = m1
            m1 = m2
            m2 = tmp
            is_swapped = true
        }
        val n = f(1, 1, m1 - m2)
        m1 -= s(1, 1, n)
        if (m1 == m2) {
            is_swapped = false
        }
        val l = f(n + 1, 2, m1)
        val r = f(n + 2, 2, m2)
        m1 -= s(n + 1, 2, l)
        m2 -= s(n + 2, 2, r)
        if (is_swapped) {
            val tmp = m1
            m1 = m2
            m2 = tmp
        }
        return intArrayOf(n + l + r + 1, m1, m2)
    }

    private fun s(a: Int, d: Int, n: Int): Int {
        return ((2L * a + (n - 1).toLong() * d) * n / 2).toInt()
    }

    private fun f(a: Int, d: Int, x: Int): Int {
        var r = ((-(2L * a - d) + sqrt(((2L * a - d) * (2L * a - d) + 8L * d * x).toDouble())) / (2 * d)).toInt()
        if (s(a, d, r) > x) {  // adjust float accuracy
            --r
        }
        return r
    }
}
