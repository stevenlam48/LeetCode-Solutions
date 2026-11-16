package tolowercase
// Time:  O(n)
// Space: O(1)

class Solution {
    fun toLowerCase(str: String): String {
        val result = StringBuilder()
        for (c in str) {
            if (c in 'A'..'Z') {
                result.append('a' + (c - 'A'))
            } else {
                result.append(c)
            }
        }
        return result.toString()
    }
}
