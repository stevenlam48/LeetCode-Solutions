package isomorphicstrings

// Time:  O(n)
// Space: O(1)

class Solution {
    fun isIsomorphic(s: String, t: String): Boolean {
        if (s.length != t.length) {
            return false
        }
        val s2t = IntArray(256)
        val t2s = IntArray(256)
        for (i in s.indices) {
            val sc = s[i].code
            val tc = t[i].code
            if (s2t[sc] == 0 && t2s[tc] == 0) {
                s2t[sc] = tc
                t2s[tc] = sc
            } else if (s2t[sc] != tc) {
                return false
            }
        }
        return true
    }
}
