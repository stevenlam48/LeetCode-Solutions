package removekdigits

// Time:  O(n)
// Space: O(n)
class Solution {
    fun removeKdigits(num: String, k: Int): String {
        // If a digit is greater than next one, delete it.
        var remaining = k
        val s = StringBuilder()
        for (c in num) {
            while (remaining > 0 && s.isNotEmpty() && s[s.length - 1] > c) {
                s.setLength(s.length - 1)
                --remaining
            }
            s.append(c)
        }

        // If all digits are increasingly sorted, delete last.
        s.setLength(s.length - remaining)

        // Strip all leading '0'
        val firstNonZero = s.indexOfFirst { it != '0' }
        return if (s.isEmpty() || firstNonZero == -1) "0" else s.substring(firstNonZero)
    }
}
