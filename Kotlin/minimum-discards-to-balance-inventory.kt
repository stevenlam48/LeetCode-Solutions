package minimumdiscardstobalanceinventory
// Time:  O(n)
// Space: O(w)

class Solution {
    fun minArrivalsToDiscard(arrivals: IntArray, w: Int, m: Int): Int {
        var result = 0
        val cnt = HashMap<Int, Int>()
        for (i in arrivals.indices) {
            cnt[arrivals[i]] = cnt.getOrDefault(arrivals[i], 0) + 1
            if (cnt[arrivals[i]] == m + 1) {
                cnt[arrivals[i]] = cnt.getValue(arrivals[i]) - 1
                arrivals[i] = 0
                ++result
            }
            if (i - w + 1 >= 0 && arrivals[i - w + 1] != 0) {
                val old = arrivals[i - w + 1]
                cnt[old] = cnt.getValue(old) - 1
                if (cnt[old] == 0) {
                    cnt.remove(old)
                }
            }
        }
        return result
    }
}
