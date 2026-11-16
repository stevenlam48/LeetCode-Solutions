package maximumoddbinarynumber
// Time:  O(n)
// Space: O(1)

class Solution {
    fun maximumOddBinaryNumber(s: String): String {
        val chars = s.toCharArray()
        var left = 0
        for (i in chars.indices) {
            if (chars[i] == '1') {
                val temp = chars[i]
                chars[i] = chars[left]
                chars[left++] = temp
            }
        }
        if (chars.last() != '1') {
            val temp = chars[chars.lastIndex]
            chars[chars.lastIndex] = chars[left - 1]
            chars[left - 1] = temp
        }
        return chars.concatToString()
    }
}
