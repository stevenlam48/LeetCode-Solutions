package reorganizestring
// Time:  O(nloga) = O(n), a is the size of alphabet
// Space: O(a) = O(1)

import java.util.PriorityQueue

class Solution {
    fun reorganizeString(S: String): String {
        val counts = HashMap<Char, Int>()
        for (c in S) {
            counts[c] = counts.getOrDefault(c, 0) + 1
        }
        if (counts.any { it.value > (S.length + 1) / 2 }) {
            return ""
        }
        val result = StringBuilder()
        val maxHeap = PriorityQueue<Pair<Int, Char>>(
            compareByDescending<Pair<Int, Char>> { it.first }.thenByDescending { it.second }
        )
        for ((c, count) in counts) {
            maxHeap.add(count to c)
        }
        while (maxHeap.size > 1) {
            val (count1, c1) = maxHeap.remove()
            val (count2, c2) = maxHeap.remove()
            if (result.isEmpty() || c1 != result.last()) {
                result.append(c1)
                result.append(c2)
                if (count1 - 1 > 0) {
                    maxHeap.add(count1 - 1 to c1)
                }
                if (count2 - 1 > 0) {
                    maxHeap.add(count2 - 1 to c2)
                }
            }
        }
        if (maxHeap.isNotEmpty()) {
            result.append(maxHeap.peek().second)
        }
        return result.toString()
    }
}
