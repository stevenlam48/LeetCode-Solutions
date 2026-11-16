package countpairsofpointswithdistancek

// Time:  O(n * k)
// Space: O(n)

// freq table
class Solution {
    fun countPairs(coordinates: Array<IntArray>, k: Int): Int {
        val MAX_Y = 1_000_000L
        var result = 0
        val cnt = HashMap<Long, Int>()
        for (x in coordinates) {
            for (i in 0..k) {
                val key = (x[0] xor i).toLong() * (MAX_Y + 1) + (x[1] xor (k - i)).toLong()
                result += cnt[key] ?: 0
            }
            val key = x[0].toLong() * (MAX_Y + 1) + x[1].toLong()
            cnt[key] = (cnt[key] ?: 0) + 1
        }
        return result
    }
}
