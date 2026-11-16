package assigncookies

// Time:  O(nlogn)
// Space: O(1)

class Solution {
    fun findContentChildren(g: IntArray, s: IntArray): Int {
        g.sort()
        s.sort()

        var result = 0
        var i = 0
        var j = 0
        while (j < s.size) {
            if (i == g.size) {
                break
            }
            if (s[j] >= g[i]) {
                ++i
                ++result
            }
            ++j
        }
        return result
    }
}
