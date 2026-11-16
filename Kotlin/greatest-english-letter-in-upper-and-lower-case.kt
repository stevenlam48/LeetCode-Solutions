package greatestenglishletterinupperandlowercase

// Time:  O(n)
// Space: O(1)

class Solution {
    fun greatestLetter(s: String): String {
        val count = IntArray(52)
        for (c in s) {
            count[if (c - 'A' < 26) c - 'A' else c - 'a' + 26]++
        }
        for (i in 25 downTo 0) {
            if (count[i] != 0 && count[i + 26] != 0) {
                return ('A' + i).toString()
            }
        }
        return ""
    }
}
