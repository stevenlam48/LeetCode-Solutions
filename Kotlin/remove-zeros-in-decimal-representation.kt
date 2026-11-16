package removezerosindecimalrepresentation
// Time:  O(logn)
// Space: O(1)

class Solution {
    fun removeZeros(n: Long): Long {
        var value = n
        var result = 0L
        while (value != 0L) {
            if (value % 10 != 0L) {
                result = result * 10 + value % 10
            }
            value /= 10
        }
        return reverse(result)
    }

    private fun reverse(n: Long): Long {
        var value = n
        var result = 0L
        while (value != 0L) {
            result = result * 10 + value % 10
            value /= 10
        }
        return result
    }
}
