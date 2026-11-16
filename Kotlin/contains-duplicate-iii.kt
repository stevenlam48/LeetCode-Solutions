package containsduplicateiii
// Time:  O(nlogk)
// Space: O(k)

import java.util.TreeMap

class Solution {
    fun containsNearbyAlmostDuplicate(nums: IntArray, k: Int, t: Int): Boolean {
        if (k < 0 || t < 0) {
            return false
        }
        val window = ArrayDeque<Long>()
        val bst = TreeMap<Long, Int>()
        var size = 0
        for (i in nums.indices) {
            if (size > k) {
                val num = window.removeFirst()
                val count = bst[num]!!
                if (count == 1) {
                    bst.remove(num)
                } else {
                    bst[num] = count - 1
                }
                --size
            }
            val it = bst.ceilingKey(nums[i].toLong() - t)
            if (it == null || it - nums[i] > t) {
                window.addLast(nums[i].toLong())
                bst[nums[i].toLong()] = bst.getOrDefault(nums[i].toLong(), 0) + 1
                ++size
            } else {
                return true
            }
        }
        return false
    }
}
