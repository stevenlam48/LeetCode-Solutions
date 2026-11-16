package minimumsensorstocovergrid

// Time:  O(1)
// Space: O(1)

class Solution {
    fun minSensors(n: Int, m: Int, k: Int): Int {
        fun ceilDivide(a: Int, b: Int): Int = (a + b - 1) / b

        return ceilDivide(n, 2 * k + 1) * ceilDivide(m, 2 * k + 1)
    }
}
