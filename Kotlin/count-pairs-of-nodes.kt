package countpairsofnodes

// Time:  O(n + e + q)
// Space: O(n + e)

// pure counting solution
class Solution {
    fun countPairs(n: Int, edges: Array<IntArray>, queries: IntArray): IntArray {
        val degree = IntArray(n + 1)
        val shared = HashMap<Long, Int>()
        for (edge in edges) {
            ++degree[edge[0]]
            ++degree[edge[1]]
            val a = minOf(edge[0], edge[1])
            val b = maxOf(edge[0], edge[1])
            val key = a.toLong() * (n + 1) + b
            shared[key] = (shared[key] ?: 0) + 1
        }
        var maxDegree = 0
        for (i in 1..n) {
            maxDegree = maxOf(maxDegree, degree[i])
        }
        val cnt = IntArray(2 * (maxDegree + 1))
        val count = HashMap<Int, Int>()
        for (i in 1..n) {
            count[degree[i]] = (count[degree[i]] ?: 0) + 1
        }
        for ((i, count1) in count) {
            for ((j, count2) in count) {
                if (i < j) {
                    cnt[i + j] += count1 * count2
                } else if (i == j) {
                    cnt[i + j] += count1 * (count1 - 1) / 2
                }
            }
        }
        for ((key, sharedDegree) in shared) {
            val i = (key / (n + 1)).toInt()
            val j = (key % (n + 1)).toInt()
            --cnt[degree[i] + degree[j]]
            ++cnt[degree[i] + degree[j] - sharedDegree]
        }
        for (i in cnt.size - 2 downTo 0) {
            cnt[i] += cnt[i + 1]
        }
        val result = IntArray(queries.size)
        for (qi in queries.indices) {
            val q = queries[qi]
            result[qi] = if (q + 1 < cnt.size) cnt[q + 1] else 0
        }
        return result
    }
}
