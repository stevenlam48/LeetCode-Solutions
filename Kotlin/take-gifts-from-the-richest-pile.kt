package takegiftsfromtherichestpile
// Time:  O(n + klogn)
// Space: O(1)

import java.util.PriorityQueue
import kotlin.math.sqrt

class Solution {
    fun pickGifts(gifts: IntArray, k: Int): Long {
        val heap = PriorityQueue<Int>(reverseOrder())
        heap.addAll(gifts.toList())
        var remaining = k
        while (--remaining >= 0) {
            heap.add(sqrt(heap.remove().toDouble()).toInt())
        }
        return heap.sumOf { it.toLong() }
    }
}
