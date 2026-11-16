package rearrangingfruits

// Time:  O(n) on average
// Space: O(n)

class Solution {
    fun minCost(basket1: IntArray, basket2: IntArray): Long {
        val cnt = HashMap<Int, Int>()
        for (x in basket1) {
            cnt[x] = (cnt[x] ?: 0) + 1
        }
        for (x in basket2) {
            cnt[x] = (cnt[x] ?: 0) - 1
        }
        if (cnt.isEmpty()) {
            return 0L
        }
        val mn = cnt.keys.min()
        val swaps = ArrayList<Int>()
        for ((k, v) in cnt) {
            if (v % 2 != 0) {
                return -1L
            }
            repeat(Math.abs(v) / 2) {
                swaps.add(k)
            }
        }
        swaps.sort()
        var result = 0L
        for (i in 0 until swaps.size / 2) {
            result += minOf(swaps[i].toLong(), mn.toLong() * 2)
        }
        return result
    }
}
