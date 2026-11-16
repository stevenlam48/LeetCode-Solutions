package matchsubstringafterreplacement

// Time:  O(n * k), n = len(s), k = len(sub)
// Space: O(m), m = len(mappings)

// brute force
class Solution {
    fun matchReplacement(s: String, sub: String, mappings: Array<CharArray>): Boolean {
        fun f(c: Char): Int {
            return if (c.isDigit()) c - '0' else if (c.isLowerCase()) c - 'a' + 10 else c - 'A' + 36
        }

        val lookup = Array(62) { BooleanArray(62) }
        for (m in mappings) {
            lookup[f(m[0])][f(m[1])] = true
        }
        val ss = IntArray(s.length) { f(s[it]) }
        val subArr = IntArray(sub.length) { f(sub[it]) }
        fun check(i: Int): Boolean {
            for (j in subArr.indices) {
                if (subArr[j] != ss[i + j] && !lookup[subArr[j]][ss[i + j]]) {
                    return false
                }
            }
            return true
        }
        for (i in 0..ss.size - subArr.size) {
            if (check(i)) {
                return true
            }
        }
        return false
    }
}
