package removingstarsfromastring
// Time:  O(n)
// Space: O(n)

class Solution {
    fun removeStars(s: String): String {
        val result = StringBuilder()
        for (c in s) {
            if (c == '*') {
                result.deleteCharAt(result.lastIndex)
            } else {
                result.append(c)
            }
        }
        return result.toString()
    }
}
