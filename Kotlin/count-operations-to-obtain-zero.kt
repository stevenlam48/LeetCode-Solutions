package countoperationstoobtainzero

// Time:  O(log(min(m, n)))
// Space: O(1)

// gcd-like solution
class Solution {
    fun countOperations(num1: Int, num2: Int): Int {
        var a = num1
        var b = num2
        var result = 0
        while (b != 0) {
            result += a / b
            val t = a % b
            a = b
            b = t
        }
        return result
    }
}
