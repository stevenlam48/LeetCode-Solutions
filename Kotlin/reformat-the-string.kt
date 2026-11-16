package reformatthestring
// Time:  O(n)
// Space: O(1)

class Solution {
    fun reformat(s: String): String {
        val count = HashMap<Char, Int>()
        var alphaCnt = 0
        for (c in s) {
            count[c] = (count[c] ?: 0) + 1
            if (c.isLetter()) {
                ++alphaCnt
            }
        }
        if (kotlin.math.abs(s.length - 2 * alphaCnt) > 1) {
            return ""
        }

        var a = 'a'
        var aEnd = 'z'
        var b = '0'
        var bEnd = '9'
        if (alphaCnt < s.length - alphaCnt) {
            a = b.also { b = a }
            aEnd = bEnd.also { bEnd = aEnd }
        }
        val result = StringBuilder()
        while (result.length < s.length) {
            a = nextChar(a, aEnd, count)
            result.append(a)
            b = nextChar(b, bEnd, count)
            result.append(b)
        }
        if (result.last() == '\u0000') {
            result.setLength(result.length - 1)
        }
        return result.toString()
    }

    private fun nextChar(start: Char, end: Char, count: HashMap<Char, Int>): Char {
        for (c in start..end) {
            if ((count[c] ?: 0) != 0) {
                count[c] = count.getValue(c) - 1
                return c
            }
        }
        return '\u0000'
    }
}
