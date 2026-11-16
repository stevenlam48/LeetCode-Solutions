package numberofequalnumbersblocks

// Time:  O(klogn), k = len(set(nums))
// Space: O(1)

// binary search
interface BigArray {
    fun size(): Long
    fun at(index: Long): Int
}

class Solution {
    fun countBlocks(nums: BigArray): Int {
        fun binarySearchRight(left0: Long, right0: Long, check: (Long) -> Boolean): Long {
            var left = left0
            var right = right0
            while (left <= right) {
                val mid = left + (right - left) / 2
                if (!check(mid)) {
                    right = mid - 1
                } else {
                    left = mid + 1
                }
            }
            return right
        }

        val n = nums.size()
        var result = 0L
        var left = 0L
        while (left != n) {
            val target = nums.at(left)
            left = binarySearchRight(left, n - 1) { x -> nums.at(x) == target } + 1
            ++result
        }
        return result.toInt()
    }
}
