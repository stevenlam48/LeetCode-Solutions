package occurrencesafterbigram

// Time:  O(n)
// Space: O(1)

class Solution {
    fun findOcurrences(text: String, first: String, second: String): List<String> {
        val result = mutableListOf<String>()
        val firstS = first + " "
        val secondS = second + " "
        val third = StringBuilder()
        var i = 0
        var j = 0
        var k = 0
        while (k < text.length) {
            val c = text[k++]
            if (i != firstS.length) {
                if (c == firstS[i]) {
                    ++i
                } else {
                    i = 0
                }
                continue
            }
            if (j != secondS.length) {
                if (c == secondS[j]) {
                    ++j
                } else {
                    k -= j + 1
                    i = 0
                    j = 0
                }
                continue
            }
            if (c != ' ') {
                third.append(c)
                continue
            }
            k -= secondS.length + third.length + 1
            i = 0
            j = 0
            result.add(third.toString())
            third.setLength(0)
        }
        if (third.isNotEmpty()) {
            result.add(third.toString())
        }
        return result
    }
}
