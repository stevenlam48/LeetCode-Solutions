package minimumnumberofverticestoreachallnodes

// Time:  O(e)
// Space: O(n)

class Solution {
    fun findSmallestSetOfVertices(n: Int, edges: Array<IntArray>): List<Int> {
        val result = mutableListOf<Int>()
        val lookup = HashSet<Int>()
        for (e in edges) {
            lookup.add(e[1])
        }
        for (i in 0 until n) {
            if (i !in lookup) {
                result.add(i)
            }
        }
        return result
    }
}
