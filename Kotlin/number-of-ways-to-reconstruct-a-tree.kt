package numberofwaystoreconstructatree

// Time:  O(nlogn)
// Space: O(n)

class Solution {
    fun checkWays(pairs: Array<IntArray>): Int {
        val adj = HashMap<Int, MutableSet<Int>>()
        for (pair in pairs) {
            adj.getOrPut(pair[0]) { HashSet() }.add(pair[1])
            adj.getOrPut(pair[1]) { HashSet() }.add(pair[0])
        }
        val n = adj.size
        var mul = false
        val lookup = HashSet<Int>()
        val nodes = adj.keys.toMutableList()
        nodes.sortWith(compareByDescending { adj.getValue(it).size })
        for (node in nodes) {
            lookup.add(node)
            var parent = 0
            for (x in adj.getValue(node)) {
                if (x !in lookup) {
                    continue
                }
                if (parent == 0 || adj.getValue(x).size < adj.getValue(parent).size) {
                    parent = x
                }
            }
            if (parent != 0) {
                for (x in adj.getValue(node)) {
                    if (x != parent && x !in adj.getValue(parent)) {
                        return 0
                    }
                }
                mul = mul || adj.getValue(node).size == adj.getValue(parent).size
            } else if (adj.getValue(node).size != n - 1) {
                return 0
            }
        }
        return if (mul) 2 else 1
    }
}
