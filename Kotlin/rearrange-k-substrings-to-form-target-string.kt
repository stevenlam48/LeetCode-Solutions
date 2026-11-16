package rearrangeksubstringstoformtargetstring

// Time:  O(n)
// Space: O(n)

class Solution {
    fun isPossibleToRearrange(s: String, t: String, k: Int): Boolean {
        val cnt = HashMap<String, Int>()
        val l = s.length / k
        var i = 0
        while (i < s.length) {
            val a = s.substring(i, i + l)
            val b = t.substring(i, i + l)
            cnt[a] = (cnt[a] ?: 0) + 1
            cnt[b] = (cnt[b] ?: 0) - 1
            i += l
        }
        return cnt.values.all { it == 0 }
    }
}
