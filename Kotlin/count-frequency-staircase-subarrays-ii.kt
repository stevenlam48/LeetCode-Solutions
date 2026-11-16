package countfrequencystaircasesubarraysii

// Time:  O(n * sqrt(n))
// Space: O(n)

// hash table
class Solution {
    fun countStaircase(nums: IntArray): Int {
        var result = 0
        val lookup = HashMap<Int, MutableList<Int>>()
        for (left in nums.size - 1 downTo 0) {
            lookup.getOrPut(nums[left]) { mutableListOf() }.add(left)
            var right = left
            var d = 0
            var l = -1
            var r = nums.size
            while (right < r && l <= r) {
                val idxs = lookup[nums[right]]!!
                if (idxs.last() == right) {
                    ++d
                    if (idxs.size < d) {
                        break
                    }
                    if (idxs.size >= d + 1) {
                        r = minOf(r, idxs[idxs.size - 1 - d])
                    }
                    l = maxOf(l, idxs[idxs.size - d])
                }
                if (l <= right) {
                    ++result
                }
                ++right
            }
        }
        return result
    }
}
