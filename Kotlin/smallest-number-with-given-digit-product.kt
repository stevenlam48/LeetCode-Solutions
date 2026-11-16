package smallestnumberwithgivendigitproduct
// Time:  O(logn)
// Space: O(logn)

class Solution {
    fun smallestNumber(n: Long): String {
        var remaining = n
        val result = StringBuilder()
        for (d in 9 downTo 2) {
            while (remaining % d == 0L) {
                remaining /= d
                result.append('0' + d)
            }
        }
        result.reverse()
        if (result.isEmpty()) {
            result.append('1')
        }
        return if (remaining == 1L) result.toString() else "-1"
    }
}
