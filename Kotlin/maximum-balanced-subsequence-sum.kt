package maximumbalancedsubsequencesum

import java.util.TreeSet

// Time:  O(nlogn)
// Space: O(n)

class Solution {
    fun maxBalancedSubsequenceSum(nums: IntArray): Long {
        val NEG_INF = Long.MIN_VALUE

        val bst = TreeSet<Pair<Int, Long>>(compareBy({ it.first }, { it.second }))

        fun query(k: Int): Long {
            if (bst.isEmpty()) {
                return NEG_INF
            }
            val it = bst.ceiling(k to 0L)
            if (it == null) {
                return bst.last().second
            }
            if (it == bst.first()) {
                return NEG_INF
            }
            return bst.lower(it)!!.second
        }

        fun update(k: Int, v: Long) {
            val it = bst.ceiling(k to 0L)
            if (it != null && it.first == k) {
                if (it.second >= v) {
                    return
                }
                bst.remove(it)
            } else {
                val prevVal = if (it == null) bst.lastOrNull()?.second else bst.lower(it)?.second
                val atBegin = if (it == null) bst.isEmpty() else it == bst.first()
                if (!(atBegin || (prevVal != null && prevVal < v))) {
                    return
                }
            }
            val jt = k to v
            bst.add(jt)
            while (true) {
                val nx = bst.higher(jt) ?: break
                if (nx.second <= jt.second) {
                    bst.remove(nx)
                } else {
                    break
                }
            }
        }

        for (i in nums.indices) {
            val value = maxOf(query(nums[i] - i + 1), 0L) + nums[i]
            update(nums[i] - i, value)
        }
        return bst.last().second
    }
}
