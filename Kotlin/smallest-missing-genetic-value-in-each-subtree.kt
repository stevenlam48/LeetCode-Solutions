package smallestmissinggeneticvalueineachsubtree

// Time:  O(n)
// Space: O(n)

class Solution {
    fun smallestMissingValueSubtree(parents: IntArray, nums: IntArray): IntArray {
        val result = IntArray(parents.size) { 1 }
        var i = nums.indexOf(1)
        if (i == -1) {
            return result
        }
        val adj = Array(parents.size) { ArrayList<Int>() }
        for (j in 1 until parents.size) {
            adj[parents[j]].add(j)
        }
        val lookup = HashSet<Int>()
        var miss = 1
        while (i >= 0) {
            iterDfs(adj, nums, i, lookup)
            while (lookup.contains(miss)) {
                ++miss
            }
            result[i] = miss
            i = parents[i]
        }
        return result
    }

    private fun iterDfs(adj: Array<ArrayList<Int>>, nums: IntArray, start: Int, lookup: HashSet<Int>) {
        val stk = ArrayDeque<Int>()
        stk.addLast(start)
        while (stk.isNotEmpty()) {
            val i = stk.removeLast()
            if (lookup.contains(nums[i])) {
                continue
            }
            lookup.add(nums[i])
            for (j in adj[i]) {
                stk.addLast(j)
            }
        }
    }
}
