package findkpairswithsmallestsums
// Time:  O(k * log(min(n, m, k))), where n is the size of num1, and m is the size of num2.
// Space: O(min(n, m, k))

import java.util.PriorityQueue

class Solution {
    private data class Entry(val sum: Long, val i: Int, val j: Int)

    fun kSmallestPairs(nums1: IntArray, nums2: IntArray, k: Int): List<IntArray> {
        val pairs = mutableListOf<IntArray>()
        if (nums1.size > nums2.size) {
            val tmp = kSmallestPairs(nums2, nums1, k)
            for (pair in tmp) {
                pairs.add(intArrayOf(pair[1], pair[0]))
            }
            return pairs
        }

        val queue = PriorityQueue<Entry>(
            compareBy<Entry> { it.sum }.thenBy { it.i }.thenBy { it.j }
        )
        fun push(i: Int, j: Int) {
            if (i < nums1.size && j < nums2.size) {
                queue.add(Entry(nums1[i].toLong() + nums2[j], i, j))
            }
        }

        push(0, 0)
        while (queue.isNotEmpty() && pairs.size < k) {
            val tmp = queue.remove()
            val i = tmp.i
            val j = tmp.j
            pairs.add(intArrayOf(nums1[i], nums2[j]))
            push(i, j + 1)
            if (j == 0) {
                push(i + 1, 0)
            }
        }
        return pairs
    }
}
