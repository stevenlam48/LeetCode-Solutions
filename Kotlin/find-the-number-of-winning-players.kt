package findthenumberofwinningplayers

// Time:  O(p), p = len(pick)
// Space: O(min(n * c, p)), c = max(y)
class Solution {
    fun winningPlayerCount(n: Int, pick: Array<IntArray>): Int {
        val cnts = HashMap<Int, HashMap<Int, Int>>()
        for (x in pick) {
            val cnt = cnts.getOrPut(x[0]) { HashMap() }
            cnt[x[1]] = (cnt[x[1]] ?: 0) + 1
        }
        var result = 0
        for ((i, cnt) in cnts) {
            if (cnt.values.any { i < it }) {
                ++result
            }
        }
        return result
    }
}
