package findasafewalkthroughagrid

// Time:  O(m * n)
// Space: O(m * n)

class Solution {
    fun findSafeWalk(grid: Array<IntArray>, health: Int): Boolean {
        val directions = arrayOf(intArrayOf(0, 1), intArrayOf(0, -1), intArrayOf(1, 0), intArrayOf(-1, 0))
        val b = intArrayOf(0, 0)
        val t = intArrayOf(grid.size - 1, grid[0].size - 1)
        if (!(0 + grid[0][0] < health)) {
            return false
        }
        val dq = ArrayDeque<Pair<IntArray, Int>>()
        dq.addLast(Pair(b, grid[0][0]))
        val lookup = HashSet<Int>()
        while (dq.isNotEmpty()) {
            val (cur, d) = dq.removeFirst()
            if (cur[0] == t[0] && cur[1] == t[1]) {
                return true
            }
            val key = cur[0] * grid[0].size + cur[1]
            if (key in lookup) {
                continue
            }
            lookup.add(key)
            for (dir in directions) {
                val nb = intArrayOf(cur[0] + dir[0], cur[1] + dir[1])
                if (!(0 <= nb[0] && nb[0] < grid.size &&
                        0 <= nb[1] && nb[1] < grid[0].size &&
                        nb[0] * grid[0].size + nb[1] !in lookup)) {
                    continue
                }
                if (grid[nb[0]][nb[1]] == 0) {
                    dq.addFirst(Pair(nb, d))
                } else if (d + 1 < health) {
                    dq.addLast(Pair(nb, d + 1))
                }
            }
        }
        return false
    }
}
