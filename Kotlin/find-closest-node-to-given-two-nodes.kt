package findclosestnodetogiventwonodes

// Time:  O(n)
// Space: O(n)

class Solution {
    fun closestMeetingNode(edges: IntArray, node1: Int, node2: Int): Int {
        fun distances(start: Int): Map<Int, Int> {
            val lookup = HashMap<Int, Int>()
            var node = start
            var distance = 0
            while (node != -1) {
                if (node in lookup) {
                    break
                }
                lookup[node] = distance++
                node = edges[node]
            }
            return lookup
        }

        val lookup1 = distances(node1)
        val lookup2 = distances(node2)
        var result = -1
        var minimum = Int.MAX_VALUE
        for ((node, distance) in lookup1) {
            if (node !in lookup2) {
                continue
            }
            val current = maxOf(distance, lookup2.getValue(node))
            if (current < minimum) {
                minimum = current
                result = node
            } else if (current == minimum && node < result) {
                result = node
            }
        }
        return result
    }
}
