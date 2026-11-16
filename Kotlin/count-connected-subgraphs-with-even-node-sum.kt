package countconnectedsubgraphswithevennodesum

// Time:  O((n + e) * 2^n)
// Space: O(n + e)

class Solution {
    fun evenSumSubgraphs(nums: IntArray, edges: Array<IntArray>): Int {
        var oddMask = 0
        val adj = Array(nums.size) { ArrayList<Int>() }

        fun even(mask: Int): Boolean {
            return (mask and oddMask).countOneBits() % 2 == 0
        }

        fun connected(mask: Int): Boolean {
            var remaining = mask
            var i = 0
            while (i < nums.size) {
                if (remaining and (1 shl i) != 0) {
                    break
                }
                ++i
            }
            remaining = remaining xor (1 shl i)
            val stk = arrayListOf(i)
            while (stk.isNotEmpty()) {
                val u = stk.removeAt(stk.lastIndex)
                for (v in adj[u]) {
                    if (remaining and (1 shl v) == 0) {
                        continue
                    }
                    remaining = remaining xor (1 shl v)
                    stk.add(v)
                }
            }
            return remaining == 0
        }

        for (e in edges) {
            adj[e[0]].add(e[1])
            adj[e[1]].add(e[0])
        }
        for (i in nums.indices) {
            if (nums[i] != 0) {
                oddMask = oddMask or (1 shl i)
            }
        }
        var result = 0
        for (mask in 1 until (1 shl nums.size)) {
            if (even(mask) && connected(mask)) {
                ++result
            }
        }
        return result
    }
}
