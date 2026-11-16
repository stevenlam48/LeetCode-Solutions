package sumofweightedmodesinsubarrays

import java.util.TreeSet

// Time:  O(nlogk)
// Space: O(k)

// bst, two pointers, sliding window
class Solution {
    fun modeWeight(nums: IntArray, k: Int): Long {
        val cnt = HashMap<Int, Int>()
        val bst = TreeSet<Pair<Int, Int>>(compareBy({ it.first }, { it.second }))
        val add = { x: Int, diff: Int ->
            if ((cnt[x] ?: 0) != 0) {
                bst.remove(Pair(-cnt[x]!!, x))
            }
            cnt[x] = (cnt[x] ?: 0) + diff
            if (cnt[x] != 0) {
                bst.add(Pair(-cnt[x]!!, x))
            } else {
                cnt.remove(x)
            }
        }

        var result = 0L
        for (i in nums.indices) {
            add(nums[i], +1)
            if (i >= k - 1) {
                val top = bst.first()
                result += (-top.first).toLong() * top.second
                add(nums[i - k + 1], -1)
            }
        }
        return result
    }
}
