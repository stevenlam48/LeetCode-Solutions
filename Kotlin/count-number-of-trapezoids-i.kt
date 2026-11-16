package countnumberoftrapezoidsi

// Time:  O(n)
// Space: O(n)

class Solution {
    fun countTrapezoids(points: Array<IntArray>): Int {
        val mod = 1_000_000_007
        val cnt = HashMap<Int, Int>()
        for (p in points) {
            cnt[p[1]] = (cnt[p[1]] ?: 0) + 1
        }
        var result = 0
        var total = 0
        for (c in cnt.values) {
            val curr = ((c.toLong() * (c - 1) / 2) % mod).toInt()
            result = ((result + (total.toLong() * curr) % mod) % mod).toInt()
            total = (total + curr) % mod
        }
        return result.toInt()
    }
}
