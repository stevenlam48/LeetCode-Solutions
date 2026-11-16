package maximizealternatingsumusingswaps

// Time:  O(n + s)
// Space: O(n + s)

// bfs, flood fill, quick select
class Solution {
    fun maxAlternatingSum(nums: IntArray, swaps: Array<IntArray>): Long {
        val adj = Array(nums.size) { ArrayList<Int>() }
        for (s in swaps) {
            adj[s[0]].add(s[1])
            adj[s[1]].add(s[0])
        }
        val lookup = BooleanArray(adj.size)

        fun bfs(u: Int): List<Int> {
            val q = ArrayList<Int>()
            if (lookup[u]) {
                return q
            }
            lookup[u] = true
            q.add(u)
            var i = 0
            while (i < q.size) {
                for (v in adj[q[i]]) {
                    if (lookup[v]) {
                        continue
                    }
                    lookup[v] = true
                    q.add(v)
                }
                ++i
            }
            return q
        }

        var result = 0L
        for (x in nums) {
            result += x
        }
        for (u in nums.indices) {
            val g = bfs(u)
            if (g.isEmpty()) {
                continue
            }
            var l = 0
            for (x in g) {
                l += x % 2
            }
            val arr = IntArray(g.size)
            for (i in g.indices) {
                arr[i] = nums[g[i]]
            }
            arr.sort()
            var sum = 0L
            for (i in 0 until l) {
                sum += arr[i]
            }
            result -= 2 * sum
        }
        return result
    }
}
