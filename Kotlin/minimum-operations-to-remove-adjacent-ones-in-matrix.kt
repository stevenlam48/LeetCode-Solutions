package minimumoperationstoremoveadjacentonesinmatrix

// Time:  O(m * n * sqrt(m + n))
// Space: O(m * n)

private fun dfs(a: Int, l: Int, g: List<MutableList<Int>>, btoa: IntArray, A: IntArray, B: IntArray): Boolean {
    if (A[a] != l) {
        return false
    }
    A[a] = -1
    for (b in g[a]) {
        if (B[b] == l + 1) {
            B[b] = 0
            if (btoa[b] == -1 || dfs(btoa[b], l + 1, g, btoa, A, B)) {
                btoa[b] = a
                return true
            }
        }
    }
    return false
}

private fun hopcroftKarp(g: MutableList<MutableList<Int>>, btoa: IntArray): Int {
    var res = 0
    val A = IntArray(g.size)
    val B = IntArray(btoa.size)
    while (true) {
        A.fill(0)
        B.fill(0)
        var cur = ArrayList<Int>()
        var next = ArrayList<Int>()
        for (a in btoa) {
            if (a != -1) {
                A[a] = -1
            }
        }
        for (a in g.indices) {
            if (A[a] == 0) {
                cur.add(a)
            }
        }
        var lay = 1
        while (true) {
            var isLast = false
            next.clear()
            for (a in cur) {
                for (b in g[a]) {
                    if (btoa[b] == -1) {
                        B[b] = lay
                        isLast = true
                    } else if (btoa[b] != a && B[b] == 0) {
                        B[b] = lay
                        next.add(btoa[b])
                    }
                }
            }
            if (isLast) {
                break
            }
            if (next.isEmpty()) {
                return res
            }
            for (a in next) {
                A[a] = lay
            }
            val tmp = cur
            cur = next
            next = tmp
            ++lay
        }
        for (a in g.indices) {
            if (dfs(a, 0, g, btoa, A, B)) {
                ++res
            }
        }
    }
}

class Solution {
    fun minimumOperations(grid: Array<IntArray>): Int {
        val adj = ArrayList<MutableList<Int>>()
        val ids = arrayOf(HashMap<Int, Int>(), HashMap<Int, Int>())
        val lookup = Array(grid.size) { BooleanArray(grid[0].size) }
        for (i in grid.indices) {
            for (j in grid[0].indices) {
                if (grid[i][j] == 0) {
                    continue
                }
                iterDfs(grid, i, j, lookup, ids, adj)
            }
        }
        val b = IntArray(ids[1].size) { -1 }
        return hopcroftKarp(adj, b)
    }

    private fun iterDfs(
        grid: Array<IntArray>,
        i0: Int,
        j0: Int,
        lookup: Array<BooleanArray>,
        ids: Array<HashMap<Int, Int>>,
        adj: MutableList<MutableList<Int>>
    ) {
        if (lookup[i0][j0]) {
            return
        }
        lookup[i0][j0] = true
        val stk = ArrayDeque<IntArray>()
        stk.addLast(intArrayOf(i0, j0, (i0 + j0) % 2))
        while (stk.isNotEmpty()) {
            val top = stk.removeLast()
            val i = top[0]
            val j = top[1]
            val color = top[2]
            for (d in DIRECTIONS) {
                val ni = i + d[0]
                val nj = j + d[1]
                if (!(0 <= ni && ni < grid.size &&
                        0 <= nj && nj < grid[0].size &&
                        grid[ni][nj] != 0)) {
                    continue
                }
                if (color == 0) {
                    val x = getId(grid, ids, i, j, color)
                    val y = getId(grid, ids, ni, nj, color xor 1)
                    while (adj.size <= x) {
                        adj.add(ArrayList<Int>())
                    }
                    adj[x].add(y)
                }
                if (lookup[ni][nj]) {
                    continue
                }
                lookup[ni][nj] = true
                stk.addLast(intArrayOf(ni, nj, color xor 1))
            }
        }
    }

    private fun getId(
        grid: Array<IntArray>,
        ids: Array<HashMap<Int, Int>>,
        i: Int,
        j: Int,
        color: Int
    ): Int {
        val x = grid[0].size * i + j
        return ids[color].getOrPut(x) { ids[color].size }
    }

    private companion object {
        val DIRECTIONS = arrayOf(
            intArrayOf(0, 1),
            intArrayOf(1, 0),
            intArrayOf(0, -1),
            intArrayOf(-1, 0)
        )
    }
}
