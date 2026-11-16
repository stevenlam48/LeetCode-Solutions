package sentencescreenfitting

// Time:  O(r + n * c)
// Space: O(n)

class Solution {
    fun wordsTyping(sentence: List<String>, rows: Int, cols: Int): Int {
        val wc = IntArray(sentence.size)
        for (i in sentence.indices) {
            wc[i] = wordsFit(sentence, i, cols)
        }
        var words = 0
        var start = 0
        for (i in 0 until rows) {
            words += wc[start]
            start = (start + wc[start]) % sentence.size
        }
        return words / sentence.size
    }

    private fun wordsFit(sentence: List<String>, start: Int, cols: Int): Int {
        if (sentence[start].length > cols) {
            return 0
        }
        var sum = sentence[start].length
        var count = 1
        var i = (start + 1) % sentence.size
        while (sum + 1 + sentence[i].length <= cols) {
            sum += 1 + sentence[i].length
            ++count
            i = (i + 1) % sentence.size
        }
        return count
    }
}
