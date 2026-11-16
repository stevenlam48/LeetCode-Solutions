package flowerplantingwithnoadjacent

// Time:  O(n)
// Space: O(n)

class Solution {
    fun gardenNoAdj(n: Int, paths: Array<IntArray>): IntArray {
        val result = IntArray(n)
        val graph = Array(n) { mutableListOf<Int>() }
        for (path in paths) {
            val x = path[0] - 1
            val y = path[1] - 1
            graph[x].add(y)
            graph[y].add(x)
        }
        for (i in 0 until n) {
            val candidates = mutableSetOf(1, 2, 3, 4)
            for (j in graph[i]) {
                candidates.remove(result[j])
            }
            result[i] = candidates.first()
        }
        return result
    }
}
