package numberofislandsii
// Time:  O(klog*k) ~= O(k), k is the length of the positions
// Space: O(k)

class Solution {
    fun numIslands2(m: Int, n: Int, positions: Array<Pair<Int, Int>>): IntArray {
        val numbers = ArrayList<Int>(positions.size)
        var number = 0
        val directions = arrayOf(Pair(0, -1), Pair(0, 1), Pair(-1, 0), Pair(1, 0))
        val set = HashMap<Int, Int>()
        for (position in positions) {
            val node = Pair(position.first, position.second)
            set[nodeId(node, n)] = nodeId(node, n)
            ++number
            for (d in directions) {
                val neighbor = Pair(position.first + d.first, position.second + d.second)
                if (neighbor.first >= 0 && neighbor.first < m &&
                    neighbor.second >= 0 && neighbor.second < n &&
                    set.containsKey(nodeId(neighbor, n))
                ) {
                    if (findSet(nodeId(node, n), set) != findSet(nodeId(neighbor, n), set)) {
                        unionSet(set, nodeId(node, n), nodeId(neighbor, n))
                        --number
                    }
                }
            }
            numbers.add(number)
        }
        return numbers.toIntArray()
    }

    private fun nodeId(node: Pair<Int, Int>, n: Int): Int = node.first * n + node.second

    private fun findSet(x: Int, set: HashMap<Int, Int>): Int {
        if (set[x] != x) {
            set[x] = findSet(set[x]!!, set)
        }
        return set[x]!!
    }

    private fun unionSet(set: HashMap<Int, Int>, x: Int, y: Int) {
        val xRoot = findSet(x, set)
        val yRoot = findSet(y, set)
        set[minOf(xRoot, yRoot)] = maxOf(xRoot, yRoot)
    }
}
