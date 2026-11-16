package checkifdfsstringsarepalindromes

// Time:  O(n)
// Space: O(n)

class Solution {
    fun findAnswer(parent: IntArray, s: String): List<Boolean> {
        val n = parent.size
        val adj = Array(n) { mutableListOf<Int>() }
        for (v in 1 until n) {
            adj[parent[v]].add(v)
        }

        var cnt = 0
        val curr = StringBuilder()
        val lookup = Array(n) { IntArray(2) }
        val stk = mutableListOf(intArrayOf(1, 0, -1))
        while (stk.isNotEmpty()) {
            val top = stk.removeAt(stk.size - 1)
            val step = top[0]
            val u = top[1]
            val left = top[2]
            if (step == 1) {
                stk.add(intArrayOf(2, u, cnt))
                for (i in adj[u].size - 1 downTo 0) {
                    stk.add(intArrayOf(1, adj[u][i], -1))
                }
            } else if (step == 2) {
                curr.append(s[u])
                lookup[u][0] = left
                lookup[u][1] = cnt
                ++cnt
            }
        }

        val p = manacher(curr.toString())
        val result = mutableListOf<Boolean>()
        for (u in 0 until n) {
            val left = lookup[u][0]
            val right = lookup[u][1]
            result.add(p[(2 * (left + 1) + 2 * (right + 1)) / 2] >= right - left + 1)
        }
        return result
    }

    private fun manacher(s: String): IntArray {
        val t = StringBuilder("^")
        for (c in s) {
            t.append('#').append(c)
        }
        t.append("#$")

        val n = t.length
        val p = IntArray(n)
        var c = 0
        var r = 0
        for (i in 1 until n - 1) {
            val iMirror = 2 * c - i
            p[i] = if (r > i) minOf(r - i, p[iMirror]) else 0
            while (t[i + 1 + p[i]] == t[i - 1 - p[i]]) {
                ++p[i]
            }
            if (i + p[i] > r) {
                c = i
                r = i + p[i]
            }
        }
        return p
    }
}
