package mostfrequentids
// Time:  O(nlogn)
// Space: O(n)

import java.util.PriorityQueue

class Solution {
    fun mostFrequentIDs(nums: IntArray, freq: IntArray): LongArray {
        val result = LongArray(nums.size)
        val cnt = HashMap<Int, Long>()
        val maxHeap = PriorityQueue<Pair<Long, Int>>(
            compareByDescending<Pair<Long, Int>> { it.first }.thenByDescending { it.second }
        )
        for (i in nums.indices) {
            cnt[nums[i]] = cnt.getOrDefault(nums[i], 0L) + freq[i]
            maxHeap.add(cnt.getValue(nums[i]) to nums[i])
            while (maxHeap.isNotEmpty() && maxHeap.peek().first != cnt[maxHeap.peek().second]) {
                maxHeap.remove()
            }
            result[i] = if (maxHeap.isNotEmpty()) maxHeap.peek().first else 0L
        }
        return result
    }
}
