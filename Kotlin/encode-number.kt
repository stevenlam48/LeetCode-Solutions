package encodenumber
// Time:  O(logn)
// Space: O(1)

class Solution {
    fun encode(num: Int): String {
        var n = num
        val result = StringBuilder()
        while (n != 0) {
            result.append(if (n % 2 != 0) '0' else '1')
            n = (n - 1) / 2
        }
        return result.reverse().toString()
    }
}
