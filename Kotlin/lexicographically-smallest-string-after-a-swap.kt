package lexicographicallysmalleststringafteraswap

// Time:  O(n)
// Space: O(1)
class Solution {
    fun getSmallestString(s: String): String {
        val chars = s.toCharArray()
        for (i in 0 until chars.size - 1) {
            if ((chars[i] - '0') % 2 != (chars[i + 1] - '0') % 2) {
                continue
            }
            if (chars[i] > chars[i + 1]) {
                val temp = chars[i]
                chars[i] = chars[i + 1]
                chars[i + 1] = temp
                break
            }
        }
        return String(chars)
    }
}
