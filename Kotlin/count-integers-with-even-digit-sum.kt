package countintegerswithevendigitsum

// Time:  O(logn)
// Space: O(1)

class Solution {
    fun countEven(num: Int): Int {
        fun parity(value: Int): Int {
            var x = value
            var result = 0
            while (x != 0) {
                result += x % 10
                x /= 10
            }
            return result % 2
        }
        return (num - parity(num)) / 2
    }
}
