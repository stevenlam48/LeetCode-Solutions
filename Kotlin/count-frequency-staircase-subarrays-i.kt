package countfrequencystaircasesubarraysi

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
                val pos = lookup[nums[right]]!!
                if (pos.last() == right) {
                    ++d
                    if (pos.size < d) {
                        break
                    }
                    if (pos.size >= d + 1) {
                        r = minOf(r, pos[pos.size - 1 - d])
                    }
                    l = maxOf(l, pos[pos.size - d])
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
