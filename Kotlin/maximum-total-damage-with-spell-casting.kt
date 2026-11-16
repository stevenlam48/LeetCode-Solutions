package maximumtotaldamagewithspellcasting
// Time:  O(nlogn)
// Space: O(1)

class Solution {
    fun maximumTotalDamage(power: IntArray): Long {
        val DIST = 2
        power.sort()
        val dp = java.util.ArrayDeque<Pair<Int, Long>>()
        var mx = 0L
        for (x in power) {
            if (dp.isNotEmpty() && dp.peekLast().first == x) {
                val last = dp.pollLast()
                dp.addLast(last.first to last.second + x)
                continue
            }
            while (dp.isNotEmpty() && dp.peekFirst().first + DIST < x) {
                mx = maxOf(mx, dp.pollFirst().second)
            }
            dp.addLast(x to mx + x)
        }
        return dp.maxOf { it.second }
    }
}
