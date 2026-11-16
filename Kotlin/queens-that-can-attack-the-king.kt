package queensthatcanattacktheking

// Time:  O(1)
// Space: O(1)

class Solution {
    fun queensAttacktheKing(queens: Array<IntArray>, king: IntArray): Array<IntArray> {
        val directions = arrayOf(
            intArrayOf(-1, 0), intArrayOf(0, 1), intArrayOf(1, 0), intArrayOf(0, -1),
            intArrayOf(-1, 1), intArrayOf(1, 1), intArrayOf(1, -1), intArrayOf(-1, -1)
        )
        val result = mutableListOf<IntArray>()
        val lookup = HashSet<Pair<Int, Int>>()
        for (queen in queens) {
            lookup.add(Pair(queen[0], queen[1]))
        }
        for (d in directions) {
            val dx = d[0]
            val dy = d[1]
            for (i in 1..7) {
                val x = king[0] + dx * i
                val y = king[1] + dy * i
                if (lookup.contains(Pair(x, y))) {
                    result.add(intArrayOf(x, y))
                    break
                }
            }
        }
        return result.toTypedArray()
    }
}
