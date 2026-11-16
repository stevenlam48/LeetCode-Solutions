package minimumnumberofoperationstoreinitializeapermutation

// Time:  O(sqrt(n))
// Space: O(sqrt(n))

import kotlin.math.sqrt

class Solution {
    fun reinitializePermutation(n: Int): Int {
        return 1 + discreteLog(2, n / 2, n - 1)
    }

    private fun discreteLog(a: Int, b: Int, m: Int): Int {
        val base = a % m
        var curr = b % m
        val n = sqrt(m.toDouble()).toInt() + 1
        var an = 1
        for (i in 0 until n) {
            an = (an.toLong() * base % m).toInt()
        }
        val vals = HashMap<Int, Int>()
        for (q in 0..n) {
            vals[curr] = q
            curr = (curr.toLong() * base % m).toInt()
        }
        curr = 1
        for (p in 1..n) {
            curr = (curr.toLong() * an % m).toInt()
            if (vals.containsKey(curr)) {
                return n * p - vals[curr]!!
            }
        }
        return -1
    }
}
