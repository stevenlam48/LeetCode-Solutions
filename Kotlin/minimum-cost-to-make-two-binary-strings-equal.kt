package minimumcosttomaketwobinarystringsequal
// Time:  O(n)
// Space: O(1)

class Solution {
    fun minimumCost(s: String, t: String, flipCost: Int, swapCost: Int, crossCost: Int): Long {
        val cnt = IntArray(2)
        for (i in s.indices) {
            if (s[i] == t[i]) {
                continue
            }
            ++cnt[s[i] - '0']
        }
        val mn = minOf(cnt[0], cnt[1]).toLong()
        val mx = maxOf(cnt[0], cnt[1]).toLong()
        val q = (mx - mn) / 2
        val r = (mx - mn) % 2
        return mn * minOf(swapCost, 2 * flipCost) + q * minOf(crossCost + swapCost, 2 * flipCost) + r * flipCost
    }
}
