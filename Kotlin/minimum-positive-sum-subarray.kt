package minimumpositivesumsubarray
// Time:  O(nlogn)
// Space: O(n)

import java.util.TreeMap

class Solution {
    fun minimumSumSubarray(nums: IntArray, l: Int, r: Int): Int {
        val prefix = IntArray(nums.size + 1)
        for (i in nums.indices) {
            prefix[i + 1] = prefix[i] + nums[i]
        }
        var result = Int.MAX_VALUE
        val bst = TreeMap<Int, Int>()
        for (i in nums.indices) {
            if (i - l + 1 >= 0) {
                val key = prefix[i - l + 1]
                bst[key] = (bst[key] ?: 0) + 1
            }
            if (i - r >= 0) {
                val key = prefix[i - r]
                val count = bst.getValue(key)
                if (count == 1) {
                    bst.remove(key)
                } else {
                    bst[key] = count - 1
                }
            }
            val predecessor = bst.lowerKey(prefix[i + 1])
            if (predecessor != null) {
                result = minOf(result, prefix[i + 1] - predecessor)
            }
        }
        return if (result != Int.MAX_VALUE) result else -1
    }
}
