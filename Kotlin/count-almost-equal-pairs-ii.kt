package countalmostequalpairsii

// Time:  O(n * l^4)
// Space: O(n * l^2 + min(n * l^4, n^2)) = O(n * l^4)

class Solution {
    fun countPairs(nums: IntArray): Int {
        val L = 7
        val POW10 = IntArray(L)
        POW10[0] = 1
        for (i in 0 until L - 1) {
            POW10[i + 1] = POW10[i] * 10
        }
        val cnt1 = HashMap<Int, Int>()
        for (x in nums) {
            cnt1[x] = (cnt1[x] ?: 0) + 1
        }
        val adj = HashMap<Int, MutableList<Int>>()
        val cnt = ArrayList<Pair<Int, Int>>()
        for ((k, v) in cnt1) {
            cnt.add(k to v)
        }
        for (idx in cnt.indices) {
            val x = cnt[idx].first
            adj.getOrPut(x) { mutableListOf() }.add(idx)
            for (i in 0 until L) {
                val a = x / POW10[i] % 10
                for (j in i + 1 until L) {
                    val b = x / POW10[j] % 10
                    if (a == b) {
                        continue
                    }
                    val y = x - a * (POW10[i] - POW10[j]) + b * (POW10[i] - POW10[j])
                    adj.getOrPut(y) { mutableListOf() }.add(idx)
                }
            }
        }
        var result = 0
        for ((_, v) in cnt1) {
            result += v * (v - 1) / 2
        }
        val lookup = HashMap<Int, MutableSet<Int>>()
        for ((_, list) in adj) {
            for (i in list.indices) {
                val v1 = cnt[list[i]].second
                for (j in i + 1 until list.size) {
                    val v2 = cnt[list[j]].second
                    if (lookup.getOrPut(list[i]) { mutableSetOf() }.contains(list[j])) {
                        continue
                    }
                    lookup.getOrPut(list[i]) { mutableSetOf() }.add(list[j])
                    result += v1 * v2
                }
            }
        }
        return result
    }
}
