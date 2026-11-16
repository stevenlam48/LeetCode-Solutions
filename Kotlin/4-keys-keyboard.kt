package p4keyskeyboard

import kotlin.math.pow

// Time:  O(1)
// Space: O(1)

class Solution {
    fun maxA(N: Int): Int {
        if (N < 7) {
            return N
        }
        if (N == 10) {
            return 20
        }
        val n = N / 5 + 1
        val n3 = 5 * n - N - 1
        val n4 = n - n3
        return (3.0.pow(n3) * 4.0.pow(n4)).toInt()
    }
}
