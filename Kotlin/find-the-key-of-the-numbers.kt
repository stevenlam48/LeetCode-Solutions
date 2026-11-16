package findthekeyofthenumbers

// Time:  O(d), d = 4
// Space: O(1)

class Solution {
    fun generateKey(num1: Int, num2: Int, num3: Int): Int {
        val L = 4
        var result = 0
        var base = 1000
        for (i in 0 until L) {
            result = result * 10 + minOf(num1 / base % 10, num2 / base % 10, num3 / base % 10)
            base /= 10
        }
        return result
    }
}
