package remove9
// Time:  O(logn)
// Space: O(1)

class Solution {
    fun newInteger(n: Int): Int {
        var value = n
        var result = 0
        var base = 1
        while (value > 0) {
            result += (value % 9) * base
            value /= 9
            base *= 10
        }
        return result
    }
}
