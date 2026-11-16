package minimumscoreafterremovalsonatree

// Time:  O(n^2)
// Space: O(n)

class Solution {
    fun minimumScore(nums: IntArray, edges: Array<IntArray>): Int {
        val adj = Array(nums.size) { mutableListOf<Int>() }
        for (e in edges) {
            adj[e[0]].add(e[1])
            adj[e[1]].add(e[0])
        }
        val left = IntArray(nums.size)
        val right = IntArray(nums.size)
        fun isAncestor(a: Int, b: Int): Boolean = left[a] <= left[b] && right[b] <= right[a]

        var cnt = 0
        val stk = ArrayDeque<IntArray>()
        stk.addLast(intArrayOf(1, 0, -1))
        while (stk.isNotEmpty()) {
            val top = stk.removeLast()
            val step = top[0]
            val u = top[1]
            val p = top[2]
            if (step == 1) {
                left[u] = cnt++
                stk.addLast(intArrayOf(2, u, p))
                for (v in adj[u]) {
                    if (v == p) {
                        continue
                    }
                    stk.addLast(intArrayOf(1, v, u))
                }
            } else {
                for (v in adj[u]) {
                    if (v == p) {
                        continue
                    }
                    nums[u] = nums[u] xor nums[v]
                }
                right[u] = cnt
            }
        }

        var result = Int.MAX_VALUE
        for (i in 1 until nums.size) {
            for (j in i + 1 until nums.size) {
                val triple = when {
                    isAncestor(i, j) -> intArrayOf(nums[0] xor nums[i], nums[i] xor nums[j], nums[j])
                    isAncestor(j, i) -> intArrayOf(nums[0] xor nums[j], nums[j] xor nums[i], nums[i])
                    else -> intArrayOf(nums[0] xor nums[i] xor nums[j], nums[i], nums[j])
                }
                result = minOf(result, triple.max() - triple.min())
            }
        }
        return result
    }
}
