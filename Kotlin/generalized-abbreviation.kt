package generalizedabbreviation

// Time:  O(n * 2^n)
// Space: O(n)

class Solution {
    fun generateAbbreviations(word: String): List<String> {
        val res = mutableListOf<String>()
        val cur = StringBuilder()
        generateAbbreviationsHelper(word, 0, cur, res)
        return res
    }

    fun generateAbbreviationsHelper(
        word: String,
        i: Int,
        cur: StringBuilder,
        res: MutableList<String>
    ) {
        if (i == word.length) {
            res.add(cur.toString())
            return
        }
        cur.append(word[i])
        generateAbbreviationsHelper(word, i + 1, cur, res)
        cur.setLength(cur.length - 1)
        if (cur.isEmpty() || !cur.last().isDigit()) {
            for (l in 1..word.length - i) {
                val s = l.toString()
                cur.append(s)
                generateAbbreviationsHelper(word, i + l, cur, res)
                cur.setLength(cur.length - s.length)
            }
        }
    }
}
