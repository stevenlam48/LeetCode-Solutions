package openthelock

// Time:  O(k * n^k + d), n is the number of alphabets,
//                        k is the length of target,
//                        d is the size of deadends
// Space: O(k * n^k + d)

class Solution {
    fun openLock(deadends: List<String>, target: String): Int {
        val dead = deadends.toHashSet()
        var q = mutableListOf("0000")
        val lookup = hashSetOf("0000")
        var depth = 0
        while (q.isNotEmpty()) {
            val nextQ = mutableListOf<String>()
            for (node in q) {
                if (node == target) {
                    return depth
                }
                if (node in dead) {
                    continue
                }
                for (i in 0 until 4) {
                    val n = node[i] - '0'
                    for (d in intArrayOf(-1, 1)) {
                        val nn = (n + d + 10) % 10
                        val neighbor = node.substring(0, i) + ('0' + nn) + node.substring(i + 1)
                        if (neighbor !in lookup) {
                            lookup.add(neighbor)
                            nextQ.add(neighbor)
                        }
                    }
                }
            }
            q = nextQ
            ++depth
        }
        return -1
    }
}
