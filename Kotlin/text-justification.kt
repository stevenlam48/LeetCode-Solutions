package textjustification
// Time:  O(n)
// Space: O(1)

class Solution {
    fun fullJustify(words: List<String>, maxWidth: Int): List<String> {
        val result = mutableListOf<String>()
        val n = words.size
        var begin = 0
        var len = 0
        for (i in 0 until n) {
            if (len + words[i].length + (i - begin) > maxWidth) {
                result.add(connect(words, maxWidth, begin, i, len, false))
                begin = i
                len = 0
            }
            len += words[i].length
        }
        result.add(connect(words, maxWidth, begin, n, len, true))
        return result
    }

    private fun connect(
        words: List<String>,
        maxWidth: Int,
        begin: Int,
        end: Int,
        len: Int,
        isLast: Boolean
    ): String {
        val s = StringBuilder()
        val n = end - begin
        for (i in 0 until n) {
            s.append(words[begin + i])
            addSpaces(i, n - 1, maxWidth - len, isLast, s)
        }
        if (s.length < maxWidth) {
            s.append(" ".repeat(maxWidth - s.length))
        }
        return s.toString()
    }

    private fun addSpaces(i: Int, spaceCnt: Int, maxWidth: Int, isLast: Boolean, s: StringBuilder) {
        if (i < spaceCnt) {
            val spaces = if (isLast) 1 else maxWidth / spaceCnt + if (i < maxWidth % spaceCnt) 1 else 0
            s.append(" ".repeat(spaces))
        }
    }
}
