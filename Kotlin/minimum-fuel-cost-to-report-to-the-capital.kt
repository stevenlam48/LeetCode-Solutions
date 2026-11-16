package minimumfuelcosttoreporttothecapital

// Time:  O(n)
// Space: O(h)

// iterative dfs
class Solution {
    fun minimumFuelCost(roads: Array<IntArray>, seats: Int): Long {
        val ceilDivide = { a: Long, b: Long -> (a + b - 1) / b }
        val adj = Array(roads.size + 1) { ArrayList<Int>() }
        for (r in roads) {
            adj[r[0]].add(r[1])
            adj[r[1]].add(r[0])
        }
        var result = 0L
        val ret = intArrayOf(1)
        val stk = ArrayDeque<Frame>()
        stk.addLast(Frame(1, 0, -1, 0, null, ret))
        while (stk.isNotEmpty()) {
            val (step, u, p, d, newRet, curRet) = stk.removeLast()
            if (step == 1) {
                stk.addLast(Frame(3, u, p, d, null, curRet))
                for (v in adj[u]) {
                    if (v == p) {
                        continue
                    }
                    val childRet = intArrayOf(1)
                    stk.addLast(Frame(2, v, u, d + 1, childRet, curRet))
                    stk.addLast(Frame(1, v, u, d + 1, null, childRet))
                }
            } else if (step == 2) {
                curRet[0] += newRet!![0]
            } else if (step == 3) {
                if (d != 0) {
                    result += ceilDivide(curRet[0].toLong(), seats.toLong())
                }
            }
        }
        return result
    }

    private data class Frame(
        val step: Int,
        val u: Int,
        val p: Int,
        val d: Int,
        val newRet: IntArray?,
        val ret: IntArray,
    )
}
