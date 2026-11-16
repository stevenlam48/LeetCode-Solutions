package nodewithhighestedgescore

// Time:  O(n)
// Space: O(n)

class Solution {
    fun edgeScore(edges: IntArray): Int {
        val score = LongArray(edges.size)
        for (u in edges.indices) {
            score[edges[u]] += u.toLong()
        }
        var result = 0
        for (i in score.indices) {
            if (score[i] > score[result]) {
                result = i
            }
        }
        return result
    }
}
