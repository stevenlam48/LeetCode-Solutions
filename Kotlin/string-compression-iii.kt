package stringcompressioniii
// Time:  O(n)
// Space: O(1)

class Solution {
    fun compressedString(word: String): String {
        val result = StringBuilder()
        var count = 0
        for (i in word.indices) {
            ++count
            if (count == 9 || i + 1 == word.length || word[i + 1] != word[i]) {
                result.append(('0'.code + count).toChar())
                result.append(word[i])
                count = 0
            }
        }
        return result.toString()
    }
}
