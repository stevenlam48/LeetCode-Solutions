package validdigitnumber

// Time:  O(logn)
// Space: O(1)

class Solution {
    fun validDigit(n: Int, x: Int): Boolean {
        var result = false
        var value = n
        while (value != 0) {
            if (value % 10 == x) {
                if (value / 10 == 0) {
                    return false
                }
                result = true
            }
            value /= 10
        }
        return result
    }
}
