package maximizegridhappiness

// Time:  O(C(m * n, i) * C(m * n - i, e))
// Space: O(min(m * n, i + e))

class Solution {
    fun getMaxGridHappiness(m: Int, n: Int, introvertsCount: Int, extrovertsCount: Int): Int {
        return iterBacktracking(m, n, introvertsCount, extrovertsCount)
    }

    private fun iterBacktracking(m: Int, n: Int, i: Int, e: Int): Int {
        var result = 0
        val curr = mutableListOf<Int>()
        val stk = java.util.ArrayDeque<Frame>()
        stk.addLast(Frame(2, i, e, 0, 0))
        while (stk.isNotEmpty()) {
            val (step, remainingI, remainingE, total, x) = stk.removeLast()
            if (step == 2) {
                if (curr.size == m * n || (remainingI == 0 && remainingE == 0)) {
                    result = maxOf(result, total)
                    continue
                }
                if (total + (remainingI + remainingE) * 120 < result) {
                    continue
                }
                if (remainingE > 0) {
                    val newTotal = countTotal(n, curr, 2, total)
                    stk.addLast(Frame(3, 0, 0, 0, 0))
                    stk.addLast(Frame(2, remainingI, remainingE - 1, newTotal, 0))
                    stk.addLast(Frame(1, 0, 0, 0, 2))
                }
                if (remainingI > 0) {
                    val newTotal = countTotal(n, curr, 1, total)
                    stk.addLast(Frame(3, 0, 0, 0, 0))
                    stk.addLast(Frame(2, remainingI - 1, remainingE, newTotal, 0))
                    stk.addLast(Frame(1, 0, 0, 0, 1))
                }
                if (left(n, curr) != 0 || up(n, curr) != 0) {
                    stk.addLast(Frame(3, 0, 0, 0, 0))
                    stk.addLast(Frame(2, remainingI, remainingE, total, 0))
                    stk.addLast(Frame(1, 0, 0, 0, 0))
                }
            } else if (step == 1) {
                curr.add(x)
            } else if (step == 3) {
                curr.removeAt(curr.lastIndex)
            }
        }
        return result
    }

    private fun left(n: Int, curr: List<Int>): Int {
        return if (curr.size % n != 0) curr[curr.lastIndex] else 0
    }

    private fun up(n: Int, curr: List<Int>): Int {
        return if (curr.size >= n) curr[curr.size - n] else 0
    }

    private fun countTotal(n: Int, curr: List<Int>, t: Int, total: Int): Int {
        val l = left(n, curr)
        val u = up(n, curr)
        return total -
            30 * ((if (l == 1) 1 else 0) + (if (u == 1) 1 else 0)) +
            20 * ((if (l == 2) 1 else 0) + (if (u == 2) 1 else 0)) +
            (120 - 30 * ((if (l != 0) 1 else 0) + (if (u != 0) 1 else 0))) * (if (t == 1) 1 else 0) +
            (40 + 20 * ((if (l != 0) 1 else 0) + (if (u != 0) 1 else 0))) * (if (t == 2) 1 else 0)
    }

    private data class Frame(
        val step: Int,
        val i: Int,
        val e: Int,
        val total: Int,
        val x: Int
    )
}
