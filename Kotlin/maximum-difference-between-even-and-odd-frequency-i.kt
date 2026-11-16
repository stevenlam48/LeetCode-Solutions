package maximumdifferencebetweenevenandoddfrequencyi

// Time:  O(n + 26)
// Space: O(26)

class Solution {
    fun maxDifference(s: String): Int {
        val cnt = IntArray(26)
        for (x in s) {
            ++cnt[x - 'a']
        }
        var mn = Int.MAX_VALUE
        var mx = 0
        for (x in cnt) {
            if (x == 0) {
                continue
            }
            if (x % 2 == 0) {
                mn = minOf(mn, x)
            } else {
                mx = maxOf(mx, x)
            }
        }
        return mx - mn
    }
}
