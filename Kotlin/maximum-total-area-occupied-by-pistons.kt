package maximumtotalareaoccupiedbypistons
// Time:  O(h)
// Space: O(h)

class Solution {
    fun maxArea(height: Int, positions: IntArray, directions: String): Long {
        val diff = IntArray(2 * height + 1)
        for (i in positions.indices) {
            if (directions[i] == 'U') {
                --diff[height - positions[i]]
                ++diff[(height - positions[i]) + height]
            } else {
                ++diff[positions[i]]
                --diff[positions[i] + height]
            }
        }
        var total = 0L
        for (p in positions) {
            total += p
        }
        var result = total
        var cnt = directions.count { it == 'U' }
        for (t in 1 until diff.size) {
            total += -(directions.length - cnt) + cnt
            result = maxOf(result, total)
            cnt += diff[t]
        }
        return result
    }
}
