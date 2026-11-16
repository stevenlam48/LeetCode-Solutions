package smallestklengthsubsequencewithoccurrencesofaletter

// Time:  O(n)
// Space: O(n)

class Solution {
    fun smallestSubsequence(s: String, k: Int, letter: Char, repetition0: Int): String {
        val stk = StringBuilder()
        var repetition = repetition0
        val suffix = IntArray(s.length + 1)
        for (i in s.length - 1 downTo 0) {
            suffix[i] = suffix[i + 1] + (if (s[i] == letter) 1 else 0)
        }
        for (i in s.indices) {
            while (stk.isNotEmpty() && stk.last() > s[i] &&
                stk.length + (s.length - i) > k &&
                (stk.last() != letter || repetition + 1 <= suffix[i])
            ) {
                if (stk.last() == letter) {
                    ++repetition
                }
                stk.setLength(stk.length - 1)
            }
            if (stk.length < minOf(k - (repetition - (if (s[i] == letter) 1 else 0)), k)) {
                if (s[i] == letter) {
                    --repetition
                }
                stk.append(s[i])
            }
        }
        return stk.toString()
    }
}
