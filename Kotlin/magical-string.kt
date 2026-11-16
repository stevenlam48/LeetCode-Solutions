package magicalstring

// Time:  O(n)
// Space: O(n)

class Solution {
    fun magicalString(n: Int): Int {
        val s = StringBuilder("122")
        var i = 2
        while (s.length < n) {
            val count = s[i] - '0'
            val next = (s[s.length - 1].code xor 3).toChar()
            repeat(count) {
                s.append(next)
            }
            ++i
        }
        var result = 0
        for (j in 0 until n) {
            if (s[j] == '1') {
                ++result
            }
        }
        return result
    }
}
