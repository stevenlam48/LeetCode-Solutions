package p2keyskeyboard

// Time:  O(sqrt(n))
// Space: O(1)

class Solution {
    fun minSteps(n: Int): Int {
        var result = 0
        var m = n
        var p = 2
        while (p * p <= m) {
            while (m % p == 0) {
                result += p
                m /= p
            }
            ++p
        }
        result += if (m > 1) m else 0
        return result
    }
}
