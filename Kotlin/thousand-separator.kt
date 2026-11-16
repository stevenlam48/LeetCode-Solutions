package thousandseparator
// Time:  O(n)
// Space: O(1)

class Solution {
    fun thousandSeparator(n: Int): String {
        val result = StringBuilder()
        val s = n.toString()
        for (i in s.indices) {
            if (i > 0 && (s.length - i) % 3 == 0) {
                result.append('.')
            }
            result.append(s[i])
        }
        return result.toString()
    }
}
