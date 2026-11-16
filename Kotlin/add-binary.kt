package addbinary

// Time:  O(n)
// Space: O(1)

class Solution {
    fun addBinary(a: String, b: String): String {
        val res = StringBuilder()
        val resLen = maxOf(a.length, b.length)

        var carry = 0
        for (i in 0 until resLen) {
            val aBitI = if (i < a.length) a[a.length - 1 - i] - '0' else 0
            val bBitI = if (i < b.length) b[b.length - 1 - i] - '0' else 0
            var sum = carry + aBitI + bBitI
            carry = sum / 2
            sum %= 2
            res.append('0' + sum)
        }
        if (carry != 0) {
            res.append('0' + carry)
        }
        return res.reverse().toString()
    }
}
