package detonatethemaximumbombs

// Time:  O(|V|^2 + |V| * |E|)
// Space: O(|V| + |E|)

class Solution {
    fun maximumDetonation(bombs: Array<IntArray>): Int {
        val adj = Array(bombs.size) { mutableListOf<Int>() }
        for (i in bombs.indices) {
            for (j in bombs.indices) {
                if (j == i) {
                    continue
                }
                val dx = (bombs[i][0] - bombs[j][0]).toLong()
                val dy = (bombs[i][1] - bombs[j][1]).toLong()
                val r = bombs[i][2].toLong()
                if (dx * dx + dy * dy <= r * r) {
                    adj[i].add(j)
                }
            }
        }
        var result = 0
        for (i in bombs.indices) {
            var q = listOf(i)
            val lookup = hashSetOf(i)
            while (q.isNotEmpty()) {
                val newQ = mutableListOf<Int>()
                for (u in q) {
                    for (v in adj[u]) {
                        if (v in lookup) {
                            continue
                        }
                        lookup.add(v)
                        newQ.add(v)
                    }
                }
                q = newQ
            }
            result = maxOf(result, lookup.size)
            if (result == bombs.size) {
                break
            }
        }
        return result
    }
}
