package concatenatenonzerodigitsandmultiplybysumi
// Time:  O(logn)
// Space: O(1)

class Solution {
    fun sumAndMultiply(n: Int): Long {
        fun reverse(value: Long): Long {
            var n = value
            var result = 0L
            while (n != 0L) {
                result = result * 10 + n % 10
                n /= 10
            }
            return result
        }

        var current = n
        var total = 0L
        var x = 0L
        while (current != 0) {
            total += current % 10
            if (current % 10 != 0) {
                x = x * 10 + current % 10
            }
            current /= 10
        }
        return reverse(x) * total
    }
}
