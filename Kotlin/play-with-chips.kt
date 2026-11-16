package playwithchips
// Time:  O(n)
// Space: O(1)

class Solution {
    fun minCostToMoveChips(chips: IntArray): Int {
        val count = IntArray(2)
        for (p in chips) {
            ++count[p % 2]
        }
        return minOf(count[0], count[1])
    }
}
