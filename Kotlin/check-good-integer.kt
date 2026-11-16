package checkgoodinteger

// Time:  O(logn)
// Space: O(1)

class Solution {
    fun checkGoodInteger(n: Int): Boolean {
        var result = 0
        var value = n
        while (value != 0) {
            val r = value % 10
            result += r * r - r
            value /= 10
        }
        return result >= 50
    }
}
