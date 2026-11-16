package countpathsthatcanformapalindromeinatree

// Time:  O(n)
// Space: O(n)

class Solution {
    fun countPalindromePaths(parent: IntArray, s: String): Long {
        val counts = hashMapOf(0 to 1)
        val adjacency = Array(parent.size) { mutableListOf<Int>() }
        for (u in parent.indices) {
            if (parent[u] != -1) {
                adjacency[parent[u]].add(u)
            }
        }
        var result = 0L
        val stack = ArrayDeque<Pair<Int, Int>>()
        stack.addLast(0 to 0)
        while (stack.isNotEmpty()) {
            val (u, initialMask) = stack.removeLast()
            var mask = initialMask
            if (u != 0) {
                mask = mask xor (1 shl (s[u] - 'a'))
                for (i in 0 until 26) {
                    result += counts[mask xor (1 shl i)] ?: 0
                }
                result += counts[mask] ?: 0
                counts[mask] = (counts[mask] ?: 0) + 1
            }
            for (v in adjacency[u]) {
                stack.addLast(v to mask)
            }
        }
        return result
    }
}
