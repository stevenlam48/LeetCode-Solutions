package smallestdivisibledigitproducti

// Time:  O(logn)
// Space: O(1)

class Solution {
    fun smallestNumber(n: Int, t: Int): Int {
        fun check(x0: Int): Boolean {
            var x = x0
            var result = 1
            while (x != 0) {
                result = (result * (x % 10)) % t
                x /= 10
            }
            return result == 0
        }

        var n0 = n
        while (!check(n0)) {
            ++n0
        }
        return n0
    }
}
