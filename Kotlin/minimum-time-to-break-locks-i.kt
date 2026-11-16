package minimumtimetobreaklocksi

// Time:  O(n^3)
// Space: O(n^2)

class Solution {
    fun findMinimumTime(strength: IntArray, K: Int): Int {
        val n = strength.size
        val adj = Array(n) { i -> IntArray(n) { j -> ceilDivide(strength[i], 1 + j * K) } }
        return hungarian(adj)
    }

    private fun ceilDivide(a: Int, b: Int): Int {
        return (a + b - 1) / b
    }

    private fun hungarian(a: Array<IntArray>): Int {
        if (a.isEmpty()) {
            return 0
        }
        val n = a.size + 1
        val m = a[0].size + 1
        val u = IntArray(n)
        val v = IntArray(m)
        val p = IntArray(m)
        val ans = IntArray(n - 1)
        for (i in 1 until n) {
            p[0] = i
            var j0 = 0
            val dist = IntArray(m) { Int.MAX_VALUE }
            val pre = IntArray(m) { -1 }
            val done = BooleanArray(m + 1)
            do {
                done[j0] = true
                val i0 = p[j0]
                var j1 = 0
                var delta = Int.MAX_VALUE
                for (j in 1 until m) {
                    if (!done[j]) {
                        val cur = a[i0 - 1][j - 1] - u[i0] - v[j]
                        if (cur < dist[j]) {
                            dist[j] = cur
                            pre[j] = j0
                        }
                        if (dist[j] < delta) {
                            delta = dist[j]
                            j1 = j
                        }
                    }
                }
                for (j in 0 until m) {
                    if (done[j]) {
                        u[p[j]] += delta
                        v[j] -= delta
                    } else {
                        dist[j] -= delta
                    }
                }
                j0 = j1
            } while (p[j0] != 0)
            while (j0 != 0) {
                val j1 = pre[j0]
                p[j0] = p[j1]
                j0 = j1
            }
        }
        for (j in 1 until m) {
            if (p[j] != 0) {
                ans[p[j] - 1] = j - 1
            }
        }
        return -v[0]
    }
}
