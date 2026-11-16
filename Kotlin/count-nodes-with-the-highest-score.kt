package countnodeswiththehighestscore

// Time:  O(n)
// Space: O(n)

class Solution {
    fun countHighestScoreNodes(parents: IntArray): Int {
        val n = parents.size
        val adj = Array(n) { mutableListOf<Int>() }
        for (i in 1 until n) {
            adj[parents[i]].add(i)
        }
        var best = 0L
        var count = 0
        val stk = ArrayDeque<Frame>()
        stk.addLast(Frame(1, 0, null, IntArray(1)))
        while (stk.isNotEmpty()) {
            val f = stk.removeLast()
            if (f.step == 1) {
                val cnts = Array(adj[f.i].size) { IntArray(1) }
                stk.addLast(Frame(2, f.i, cnts, f.ret))
                for (j in adj[f.i].indices) {
                    stk.addLast(Frame(1, adj[f.i][j], null, cnts[j]))
                }
            } else {
                val cnts = f.cnts!!
                var total = 1
                for (c in cnts) {
                    total += c[0]
                }
                f.ret[0] = total
                var score = maxOf(n - total, 1).toLong()
                for (c in cnts) {
                    score *= c[0]
                }
                if (score > best) {
                    best = score
                    count = 1
                } else if (score == best) {
                    ++count
                }
            }
        }
        return count
    }

    private data class Frame(
        val step: Int,
        val i: Int,
        val cnts: Array<IntArray>?,
        val ret: IntArray
    )
}
