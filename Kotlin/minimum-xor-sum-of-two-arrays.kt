package minimumxorsumoftwoarrays

// Time:  O(n^3)
// Space: O(n^2)

// weighted bipartite matching solution
class Solution {
    fun minimumXORSum(nums1: IntArray, nums2: IntArray): Int {
        val adj = Array(nums1.size) { IntArray(nums2.size) }
        for (i in nums1.indices) {
            for (j in nums2.indices) {
                adj[i][j] = nums1[i] xor nums2[j]
            }
        }
        return hungarian(adj).first
    }

    // Template modified from:
    // https://github.com/kth-competitive-programming/kactl/blob/main/content/graph/WeightedMatching.h
    private fun hungarian(a: Array<IntArray>): Pair<Int, IntArray> {  // Time: O(n^2 * m), Space: O(n + m)
        if (a.isEmpty()) return Pair(0, IntArray(0))
        val n = a.size + 1
        val m = a[0].size + 1
        val u = IntArray(n)
        val v = IntArray(m)
        val p = IntArray(m)
        val ans = IntArray(n - 1)
        for (i in 1 until n) {
            p[0] = i
            var j0 = 0 // add "dummy" worker 0
            val dist = IntArray(m) { Int.MAX_VALUE }
            val pre = IntArray(m) { -1 }
            val done = BooleanArray(m + 1)
            do { // dijkstra
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
            while (j0 != 0) { // update alternating path
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
        return Pair(-v[0], ans) // min cost
    }
}
