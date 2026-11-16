package maximumscoreofanodesequence

// Time:  O(|V| + |E|)
// Space: O(|V|)

import java.util.PriorityQueue

class Solution {
    fun maximumScore(scores: IntArray, edges: Array<IntArray>): Int {
        val top3 = Array(scores.size) {
            PriorityQueue<Pair<Int, Int>>(
                3,
                compareBy<Pair<Int, Int>> { it.first }.thenBy { it.second }
            )
        }

        fun findTop3(x: Int, heap: PriorityQueue<Pair<Int, Int>>) {
            heap.add(scores[x] to x)
            if (heap.size > 3) {
                heap.poll()
            }
        }

        for (e in edges) {
            findTop3(e[1], top3[e[0]])
            findTop3(e[0], top3[e[1]])
        }
        var result = -1
        for (e in edges) {
            val a = e[0]
            val b = e[1]
            for ((_, c) in top3[a]) {
                if (c == b) {
                    continue
                }
                for ((_, d) in top3[b]) {
                    if (d == a || d == c) {
                        continue
                    }
                    result = maxOf(result, scores[a] + scores[b] + scores[c] + scores[d])
                }
            }
        }
        return result
    }
}
