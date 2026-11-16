package maximumscoreafterbinaryswaps
// Time:  O(nlogn)
// Space: O(n)

import java.util.PriorityQueue

class Solution {
    fun maximumScore(nums: IntArray, s: String): Long {
        var result = 0L
        val maxHeap = PriorityQueue<Int>(reverseOrder())
        for (i in nums.indices) {
            maxHeap.add(nums[i])
            if (s[i] == '1') {
                result += maxHeap.remove()
            }
        }
        return result
    }
}
