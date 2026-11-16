package earliestsecondtomarkindicesii

// Time:  O((m + nlogn) * logm)
// Space: O(n)

// binary search, greedy, heap
class Solution {
    fun earliestSecondToMarkIndices(nums: IntArray, changeIndices: IntArray): Int {
        val lookup = IntArray(nums.size) { -1 }
        for (i in changeIndices.size - 1 downTo 0) {
            if (nums[changeIndices[i] - 1] != 0) {
                lookup[changeIndices[i] - 1] = i
            }
        }
        val total = nums.sumOf { it.toLong() } + nums.size
        fun check(t: Int): Boolean {
            val minHeap = java.util.PriorityQueue<Int>()
            var total2 = 0L
            var cnt = 0L
            for (i in t - 1 downTo 0) {
                if (i != lookup[changeIndices[i] - 1]) {
                    ++cnt
                    continue
                }
                minHeap.add(nums[changeIndices[i] - 1])
                total2 += nums[changeIndices[i] - 1]
                if (cnt != 0L) {
                    --cnt
                } else {
                    ++cnt
                    total2 -= minHeap.poll()
                }
            }
            return total - (total2 + minHeap.size) <= cnt
        }

        var total2 = 0L
        for (i in nums.indices) {
            total2 += if (lookup[i] != -1) 1 else nums[i]
        }
        var left = total2 + nums.size
        var right = changeIndices.size.toLong()
        while (left <= right) {
            val mid = left + (right - left) / 2
            if (check(mid.toInt())) {
                right = mid - 1
            } else {
                left = mid + 1
            }
        }
        return if (left <= changeIndices.size) left.toInt() else -1
    }
}
