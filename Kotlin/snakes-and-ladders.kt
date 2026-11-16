package snakesandladders

// Time:  O(n^2)
// Space: O(n^2)

class Solution {
    fun snakesAndLadders(board: Array<IntArray>): Int {
        val n = board.size
        val lookup = HashMap<Int, Int>()
        lookup[1] = 0
        val q = ArrayDeque<Int>()
        q.addLast(1)
        while (q.isNotEmpty()) {
            val s = q.removeFirst()
            if (s == n * n) {
                return lookup.getValue(s)
            }
            for (i in s + 1..minOf(s + 6, n * n)) {
                val (r, c) = coordinate(n, i)
                var s2 = i
                if (board[r][c] != -1) {
                    s2 = board[r][c]
                }
                if (!lookup.containsKey(s2)) {
                    lookup[s2] = lookup.getValue(s) + 1
                    q.addLast(s2)
                }
            }
        }
        return -1
    }

    private fun coordinate(n: Int, s: Int): Pair<Int, Int> {
        val a = (s - 1) / n
        val b = (s - 1) % n
        val r = n - 1 - a
        val c = if (r % 2 != n % 2) b else n - 1 - b
        return Pair(r, c)
    }
}
