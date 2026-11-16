package performstringshifts

// Time:  O(n + l)
// Space: O(1)

class Solution {
    fun stringShift(s: String, shift: Array<IntArray>): String {
        var leftShift = 0
        for (x in shift) {
            if (x[0] == 0) {
                leftShift += x[1]
            } else {
                leftShift -= x[1]
            }
        }
        val n = s.length
        leftShift = (leftShift % n + n) % n
        val chars = s.toCharArray()
        reverse(chars, 0, leftShift)
        reverse(chars, leftShift, n)
        reverse(chars, 0, n)
        return String(chars)
    }

    private fun reverse(chars: CharArray, from: Int, to: Int) {
        var i = from
        var j = to - 1
        while (i < j) {
            val tmp = chars[i]
            chars[i] = chars[j]
            chars[j] = tmp
            ++i
            --j
        }
    }
}
