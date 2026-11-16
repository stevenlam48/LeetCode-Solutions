package checkifthenumberisfascinating

// Time:  O(logn)
// Space: O(1)
class Solution {
    fun isFascinating(n: Int): Boolean {
        var lookup = 0
        fun check(x: Int): Boolean {
            var value = x
            while (value != 0) {
                val d = value % 10
                if (d == 0 || lookup and (1 shl d) != 0) {
                    return false
                }
                lookup = lookup or (1 shl d)
                value /= 10
            }
            return true
        }

        return check(n) && check(2 * n) && check(3 * n)
    }
}
