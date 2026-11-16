package minimumwindowsubstring

// Time:  O(n)
// Space: O(k)

class Solution {
    fun minWindow(s: String, t: String): String {
        val count = HashMap<Char, Int>()
        for (c in t) {
            count[c] = (count[c] ?: 0) + 1
        }
        var remain = t.length
        var left = -1
        var right = -1
        var i = 0
        for (j in s.indices) {
            val c = s[j]
            val old = count[c] ?: 0
            count[c] = old - 1
            if (old > 0) {
                --remain
            }
            if (remain != 0) {
                continue
            }
            while ((count[s[i]] ?: 0) < 0) {
                count[s[i]] = (count[s[i]] ?: 0) + 1
                ++i
            }
            if (right == -1 || j - i + 1 < right - left + 1) {
                left = i
                right = j
            }
        }
        return if (left >= 0) s.substring(left, right + 1) else ""
    }
}
