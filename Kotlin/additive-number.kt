package additivenumber

// Time:  O(n^3)
// Space: O(n)

class Solution {
    fun isAdditiveNumber(num: String): Boolean {
        for (i in 1 until num.length) {
            for (j in i + 1 until num.length) {
                var s1 = num.substring(0, i)
                var s2 = num.substring(i, j)
                if ((s1.length > 1 && s1[0] == '0') ||
                    (s2.length > 1 && s2[0] == '0')
                ) {
                    continue
                }
                var next = add(s1, s2)
                var cur = s1 + s2 + next
                while (cur.length < num.length) {
                    s1 = s2
                    s2 = next
                    next = add(s1, s2)
                    cur += next
                }
                if (cur == num) {
                    return true
                }
            }
        }
        return false
    }

    private fun add(m: String, n: String): String {
        val result = StringBuilder()
        val resultLength = maxOf(m.length, n.length)
        var carry = 0
        for (i in 0 until resultLength) {
            val mDigit = if (i < m.length) m[m.length - 1 - i] - '0' else 0
            val nDigit = if (i < n.length) n[n.length - 1 - i] - '0' else 0
            var sum = carry + mDigit + nDigit
            carry = sum / 10
            sum %= 10
            result.append('0' + sum)
        }
        if (carry != 0) {
            result.append('0' + carry)
        }
        return result.reverse().toString()
    }
}
