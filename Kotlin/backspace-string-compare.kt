package backspacestringcompare

// Time:  O(m + n)
// Space: O(1)

class Solution {
    fun backspaceCompare(S: String, T: String): Boolean {
        var i = S.length - 1
        var j = T.length - 1
        while (i >= 0 || j >= 0) {
            val (nextI, charS) = findNextChar(S, i)
            i = nextI
            val (nextJ, charT) = findNextChar(T, j)
            j = nextJ
            if (charS != charT) {
                return false
            }
            --i
            --j
        }
        return true
    }

    private fun findNextChar(s: String, start: Int): Pair<Int, Char> {
        var i = start
        var skip = 0
        while (i >= 0) {
            if (s[i] == '#') {
                ++skip
            } else if (skip > 0) {
                --skip
            } else {
                return Pair(i, s[i])
            }
            --i
        }
        return Pair(-1, '\u0000')
    }
}
