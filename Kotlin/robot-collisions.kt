package robotcollisions

// Time:  O(nlogn)
// Space: O(n)

// sort, simulation, stack
class Solution {
    fun survivedRobotsHealths(positions: IntArray, healths: IntArray, directions: String): IntArray {
        val idxs = positions.indices.sortedBy { positions[it] }
        val h = healths.copyOf()

        val stk = ArrayDeque<Int>()
        for (i in idxs) {
            if (directions[i] == 'R') {
                stk.addLast(i)
                continue
            }
            while (stk.isNotEmpty()) {
                val top = stk.last()
                if (h[top] == h[i]) {
                    h[top] = 0
                    h[i] = 0
                    stk.removeLast()
                    break
                }
                if (h[top] > h[i]) {
                    h[i] = 0
                    --h[top]
                    break
                }
                h[top] = 0
                --h[i]
                stk.removeLast()
            }
        }

        return h.filter { it != 0 }.toIntArray()
    }
}
