package minimumheighttrees

// Time:  O(n)
// Space: O(n)

class Solution {
    fun findMinHeightTrees(n: Int, edges: Array<IntArray>): IntArray {
        if (n == 1) {
            return intArrayOf(0)
        }

        val neighbors = HashMap<Int, HashSet<Int>>()
        for (e in edges) {
            val u = e[0]
            val v = e[1]
            neighbors.getOrPut(u) { HashSet() }.add(v)
            neighbors.getOrPut(v) { HashSet() }.add(u)
        }

        var preLevel = ArrayList<Int>()
        var curLevel = ArrayList<Int>()
        val unvisited = HashSet<Int>()
        for (i in 0 until n) {
            if (neighbors[i]?.size == 1) {
                preLevel.add(i)
            }
            unvisited.add(i)
        }

        while (unvisited.size > 2) {
            curLevel = ArrayList()
            for (u in preLevel) {
                unvisited.remove(u)
                for (v in neighbors[u]!!) {
                    if (unvisited.contains(v)) {
                        neighbors[v]!!.remove(u)
                        if (neighbors[v]!!.size == 1) {
                            curLevel.add(v)
                        }
                    }
                }
            }
            preLevel = curLevel
        }

        return unvisited.toIntArray()
    }
}
