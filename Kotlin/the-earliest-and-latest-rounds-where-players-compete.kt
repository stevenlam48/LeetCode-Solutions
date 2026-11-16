package theearliestandlatestroundswhereplayerscompete
// Time:  O(n^2) states * O(n^2) per state = O(n^4)
// Space: O(n^2 + (n/2)^2 + (n/4)^2 + ... ) = O(n^2)

class Solution {
    fun earliestAndLatest(n: Int, firstPlayer: Int, secondPlayer: Int): IntArray {
        val lookup = HashMap<State, IntArray>()
        return memoization(n, firstPlayer - 1, n - secondPlayer, lookup)
    }

    private fun memoization(t: Int, l: Int, r: Int, lookup: HashMap<State, IntArray>): IntArray {
        var left = l
        var right = r
        val originalKey = State(t, left, right)
        lookup[originalKey]?.let { return it }
        if (left == right) {
            return intArrayOf(1, 1)
        }
        if (left > right) {
            val tmp = left
            left = right
            right = tmp
        }
        val key = State(t, left, right)
        lookup[key]?.let { return it }
        val result = intArrayOf(Int.MAX_VALUE, 0)
        for (i in 0..left) {
            val nt = (t + 1) / 2
            val pairCnt = t / 2
            val lLoseCnt = left - i
            val lWinCnt = i + 1
            val minJ = maxOf(lLoseCnt, right - (pairCnt - lLoseCnt))
            val maxJ = minOf(right - lWinCnt, (nt - lWinCnt) - 1)
            for (j in minJ..maxJ) {
                val tmp = memoization(nt, i, j, lookup)
                result[0] = minOf(result[0], tmp[0] + 1)
                result[1] = maxOf(result[1], tmp[1] + 1)
            }
        }
        lookup[key] = result
        return result
    }

    private data class State(val t: Int, val l: Int, val r: Int)
}
