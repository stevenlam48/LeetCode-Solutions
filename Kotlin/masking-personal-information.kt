package maskingpersonalinformation

// Time:  O(1)
// Space: O(1)

class Solution {
    fun maskPII(s: String): String {
        val at = s.indexOf('@')
        if (at != -1) {
            val lower = s.lowercase()
            return lower.substring(0, 1) + "*****" + lower.substring(at - 1)
        }
        val digits = s.filter { it.isDigit() }
        val local = "***-***-" + digits.substring(digits.length - 4)
        if (digits.length == 10) {
            return local
        }
        return "+" + "*".repeat(digits.length - 10) + "-" + local
    }
}
