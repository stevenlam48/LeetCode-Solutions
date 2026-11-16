package maximumscorefromremovingsubstrings

// Time:  O(n)
// Space: O(1)

class Solution {
    fun maximumGain(s: String, x: Int, y: Int): Int {
        var a = "ab"
        var b = "ba"
        var first = x
        var second = y
        if (first < second) {
            a = "ba"
            b = "ab"
            val temp = first
            first = second
            second = temp
        }
        val input = StringBuilder(s)
        return remove(input, a, first) + remove(input, b, second)
    }

    private fun remove(s: StringBuilder, a: String, x: Int): Int {
        var i = 0
        var result = 0
        for (j in s.indices) {
            s[i] = s[j]
            i++
            if (i >= 2 && s[i - 2] == a[0] && s[i - 1] == a[1]) {
                i -= 2
                result += x
            }
        }
        s.setLength(i)
        return result
    }
}
