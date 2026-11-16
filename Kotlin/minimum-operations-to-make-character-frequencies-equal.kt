package minimumoperationstomakecharacterfrequenciesequal

// Time:  O(26 * n)
// Space: O(26)

// freq table, dp
class Solution {
    fun makeStringGood(s: String): Int {
        val cnt = IntArray(26)
        for (c in s) {
            ++cnt[c - 'a']
        }
        var mx = 0
        var mn = s.length
        for (x in cnt) {
            mx = maxOf(mx, x)
            mn = minOf(mn, x)
        }
        var result = s.length
        for (f in mn..mx) {
            var dp1 = 0
            var dp2 = 0
            for (i in 0 until 26) {
                if (cnt[i] == 0) {
                    continue
                }
                var newDp1: Int
                var newDp2: Int
                if (cnt[i] >= f) {
                    newDp1 = s.length
                    newDp2 = minOf(dp1, dp2) + (cnt[i] - f)
                } else {
                    val free = if (i - 1 >= 0) {
                        if (cnt[i - 1] >= f) cnt[i - 1] - f else cnt[i - 1]
                    } else {
                        0
                    }
                    newDp1 = minOf(minOf(dp1, dp2) + (f - cnt[i]), dp2 + maxOf((f - cnt[i]) - free, 0))
                    newDp2 = minOf(dp1, dp2) + cnt[i]
                }
                dp1 = newDp1
                dp2 = newDp2
            }
            result = minOf(result, dp1, dp2)
        }
        return result
    }
}
