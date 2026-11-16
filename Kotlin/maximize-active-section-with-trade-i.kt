package maximizeactivesectionwithtradei

// Time:  O(n)
// Space: O(1)

// greedy
class Solution {
    fun maxActiveSectionsAfterTrade(s: String): Int {
        var prev = 0
        var curr = 0
        var mx = 0
        var cnt1 = 0
        for (x in s) {
            if (x == '0') {
                ++curr
            } else {
                if (curr != 0) {
                    prev = curr
                    curr = 0
                }
                ++cnt1
            }
            mx = maxOf(mx, prev + curr)
        }
        return if (mx == prev || mx == curr) cnt1 else mx + cnt1
    }
}
