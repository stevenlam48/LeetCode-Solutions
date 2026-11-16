package createcomponentswithsamevalue

// Time:  O(n * sqrt(n))
// Space: O(n)

class Solution {
    fun componentValue(nums: IntArray, edges: Array<IntArray>): Int {
        val adj = Array(nums.size) { mutableListOf<Int>() }
        for (e in edges) {
            adj[e[0]].add(e[1])
            adj[e[1]].add(e[0])
        }

        fun bfs(target: Int): Boolean {
            val total = nums.copyOf()
            val cnt = IntArray(nums.size) { adj[it].size }
            var q = mutableListOf<Int>()
            for (u in nums.indices) {
                if (cnt[u] == 1) {
                    q.add(u)
                }
            }
            while (q.isNotEmpty()) {
                val newQ = mutableListOf<Int>()
                for (u in q) {
                    if (total[u] > target) {
                        return false
                    }
                    if (total[u] == target) {
                        total[u] = 0
                    }
                    for (v in adj[u]) {
                        total[v] += total[u]
                        --cnt[v]
                        if (cnt[v] == 1) {
                            newQ.add(v)
                        }
                    }
                }
                q = newQ
            }
            return true
        }

        val total = nums.sum()
        for (cnt in nums.size downTo 2) {
            if (total % cnt == 0 && bfs(total / cnt)) {
                return cnt - 1
            }
        }
        return 0
    }
}
