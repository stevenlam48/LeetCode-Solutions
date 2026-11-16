package minimumremovalstoachievetargetxor

// Time:  O(n * r), r = max(nums)
// Space: O(r)

class Solution {
    fun minRemovals(nums: IntArray, target: Int): Int {
        fun bfs(t: Int): Int {
            val dist = HashMap<Int, Int>()
            dist[0] = 0
            var q = mutableListOf(0)
            while (q.isNotEmpty()) {
                val newQ = mutableListOf<Int>()
                for (k in q) {
                    if (k == t) {
                        return dist[k]!!
                    }
                    for (x in nums) {
                        if (dist.containsKey(k xor x)) {
                            continue
                        }
                        dist[k xor x] = dist[k]!! + 1
                        newQ.add(k xor x)
                    }
                }
                q = newQ
            }
            return -1
        }

        var t = target
        for (x in nums) {
            t = t xor x
        }
        return bfs(t)
    }
}
