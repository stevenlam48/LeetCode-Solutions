package makethestringgreat

// Time:  O(n)
// Space: O(1)

class Solution {
    fun makeGood(s: String): String {
        val result = StringBuilder()
        for (ch in s) {
            val counterCh = if (ch.isLowerCase()) ch.uppercaseChar() else ch.lowercaseChar()
            if (result.isNotEmpty() && result.last() == counterCh) {
                result.deleteCharAt(result.length - 1)
            } else {
                result.append(ch)
            }
        }
        return result.toString()
    }
}
