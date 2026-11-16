package numberofblackblocks

// Time:  O(c), c = len(coordinates)
// Space: O(c)

class Solution {
    fun countBlackBlocks(m: Int, n: Int, coordinates: Array<IntArray>): LongArray {
        val L = 2

        val cnt = HashMap<Long, Int>()
        for (c in coordinates) {
            val x = c[0]
            val y = c[1]
            var nx = maxOf(x - (L - 1), 0)
            while (nx < minOf(x + 1, m - (L - 1))) {
                var ny = maxOf(y - (L - 1), 0)
                while (ny < minOf(y + 1, n - (L - 1))) {
                    val key = nx.toLong() * n + ny
                    cnt[key] = (cnt[key] ?: 0) + 1
                    ++ny
                }
                ++nx
            }
        }
        val result = LongArray(L * L + 1)
        for (c in cnt.values) {
            ++result[c]
        }
        var sum = 0L
        for (i in 1 until result.size) {
            sum += result[i]
        }
        result[0] = (m - (L - 1)).toLong() * (n - (L - 1)) - sum
        return result
    }
}
