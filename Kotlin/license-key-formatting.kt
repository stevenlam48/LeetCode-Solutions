package licensekeyformatting
// Time:  O(n)
// Space: O(1)

class Solution {
    fun licenseKeyFormatting(S: String, K: Int): String {
        val result = StringBuilder()
        for (i in S.lastIndex downTo 0) {
            val c = S[i]
            if (c == '-') {
                continue
            }
            if (result.length % (K + 1) == K) {
                result.append('-')
            }
            result.append(c.uppercaseChar())
        }
        return result.reverse().toString()
    }
}
