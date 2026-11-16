package pyramidtransitionmatrix

// Time:  O((a^(b+1)-a)/(a-1)) = O(a^b) , a is the size of allowed,
//                                        b is the length of bottom
// Space: O((a^(b+1)-a)/(a-1)) = O(a^b)

class Solution {
    fun pyramidTransition(bottom: String, allowed: List<String>): Boolean {
        val edges = Array(7) { Array(7) { mutableListOf<Int>() } }
        val lookup = hashSetOf<String>()
        for (s in allowed) {
            edges[s[0] - 'A'][s[1] - 'A'].add(s[2] - 'A')
        }
        return pyramidTransitionHelper(bottom, edges, lookup)
    }

    private fun pyramidTransitionHelper(
        bottom: String,
        edges: Array<Array<MutableList<Int>>>,
        lookup: MutableSet<String>
    ): Boolean {
        if (bottom.length == 1) {
            return true
        }
        for (i in 0 until bottom.length - 1) {
            if (edges[bottom[i] - 'A'][bottom[i + 1] - 'A'].isEmpty()) {
                return false
            }
        }
        if (!lookup.add(bottom)) {
            return false
        }
        val newBottom = CharArray(bottom.length - 1) { 'A' }
        return dfs(bottom, edges, newBottom, 0, lookup)
    }

    private fun dfs(
        bottom: String,
        edges: Array<Array<MutableList<Int>>>,
        newBottom: CharArray,
        idx: Int,
        lookup: MutableSet<String>
    ): Boolean {
        if (idx == bottom.length - 1) {
            return pyramidTransitionHelper(String(newBottom), edges, lookup)
        }
        for (i in edges[bottom[idx] - 'A'][bottom[idx + 1] - 'A']) {
            newBottom[idx] = (i + 'A'.code).toChar()
            if (dfs(bottom, edges, newBottom, idx + 1, lookup)) {
                return true
            }
        }
        return false
    }
}
